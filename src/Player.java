import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import math.Vector2D;

public class Player extends GameObject {
	@Override
	public void start(MainPanel mainPanel) {
		position.x = 100;
		position.y = 100;
		radius = 10;
		color = Color.RED;
	}

	@Override
	public void update(MainPanel mainPanel) {
		moveDirection.zero();
		// key processing
		if(mainPanel.keys.get(KeyEvent.VK_A)) {
			if(mainPanel.keys.get(KeyEvent.VK_W)) {
				angle = -135;
			} else if(mainPanel.keys.get(KeyEvent.VK_S)) {
				angle = -45;
			} else {
				angle = -90;
			}
			moveDirection = front().mulEq(2);
		} else if(mainPanel.keys.get(KeyEvent.VK_D)) {
			if(mainPanel.keys.get(KeyEvent.VK_W)) {
				angle = 135;
			} else if(mainPanel.keys.get(KeyEvent.VK_S)) {
				angle = 45;
			} else {
				angle = 90;
			}
			moveDirection = front().mulEq(2);
		} else if(mainPanel.keys.get(KeyEvent.VK_W)) {
			angle = 180;
			moveDirection = front().mulEq(2);
		} else if(mainPanel.keys.get(KeyEvent.VK_S)) {
			angle = 0;
			moveDirection = front().mulEq(2);
		}
	}

	@Override
	public void display(Graphics g) {
		Point2D.Float[] p = { new Point2D.Float(-10, 10), new Point2D.Float(0, -10), new Point2D.Float(10, 10) };
		Vector2D front = front();

		for(int i = 0; i < 3; ++i) {
			p[i].setLocation(p[i].x * scale.x, p[i].y * scale.y); // scale
			p[i].setLocation(front.y * p[i].x - front.x * p[i].y, (front.x * p[i].x + front.y * p[i].y) * -1); // rotation
			p[i].setLocation(p[i].x + position.x, p[i].y + position.y); // position
		}

		g.setColor(color);

		g.drawLine((int)p[0].x, (int)p[0].y, (int)p[1].x, (int)p[1].y);
		g.drawLine((int)p[1].x, (int)p[1].y, (int)p[2].x, (int)p[2].y);
	}
}
