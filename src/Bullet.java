import java.awt.Graphics;

public class Bullet extends GameObject {
	boolean isUse = false;

	@Override
	public void start(MainPanel mainPanel) {
		isInnerWindow = false;
		radius = 5;
	}

	@Override
	public void update(MainPanel mainPanel) {
		if(isUse) {
			if(isInside() == false) {
				isUse = false;
				moveDirection.zero();
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
