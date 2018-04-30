import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public class Player extends GameObject {
	@Override
	public void start(MainPanel mainPanel) {
		position.x = 100;
		position.y = 100;
		radius = 20;
		color = Color.RED;
	}

	@Override
	public void update(MainPanel mainPanel) {
		moveDirection.setLocation(0, 0);
		// key processing
		if(mainPanel.keys.get(KeyEvent.VK_A)) {
			moveDirection.x = -2;
			angle = 270;
		}
		if(mainPanel.keys.get(KeyEvent.VK_D)) {
			moveDirection.x = 2;
			angle = 90;
		}
		if(mainPanel.keys.get(KeyEvent.VK_W)) {
			moveDirection.y = -2;
			angle = 180;
		}
		if(mainPanel.keys.get(KeyEvent.VK_S)) {
			moveDirection.y = 2;
			angle = 0;
		}
	}

	@Override
	public void display(Graphics g) {
		Point2D.Float[] p = { new Point2D.Float(-10, 10), new Point2D.Float(0, -10), new Point2D.Float(10, 10) };
		float s = (float)Math.sin(Math.toRadians(angle));
		float c = (float)Math.cos(Math.toRadians(angle));

		for(int i = 0; i < 3; ++i) {
			p[i].setLocation(p[i].x * scale.x, p[i].y * scale.y); // scale
			p[i].setLocation(c * p[i].x - s * p[i].y, (s * p[i].x + c * p[i].y) * -1); // rotation
			p[i].setLocation(p[i].x + position.x, p[i].y + position.y); // position
		}

		g.setColor(color);

		g.drawLine((int)p[0].x, (int)p[0].y, (int)p[1].x, (int)p[1].y);
		g.drawLine((int)p[1].x, (int)p[1].y, (int)p[2].x, (int)p[2].y);
	}
}
