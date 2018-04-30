import java.awt.Graphics;

public class Bullet extends GameObject {
	boolean isUse = false;

	@Override
	public void start(MainPanel mainPanel) {
		isInnerWindow = false;
		radius = 10;
	}

	@Override
	public void update(MainPanel mainPanel) {
		if(isUse) {
			if(isInside() == false) {
				isUse = false;
				moveDirection.setLocation(0, 0);
			}
		}
	}

	@Override
	public void display(Graphics g) {
		if(isUse) {
			g.setColor(color);
			g.fillOval((int)position.x - 5, (int)position.y - 5, 10, 10);
		}
	}
}
