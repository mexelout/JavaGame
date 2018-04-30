import java.awt.Graphics;

public class Bullet extends GameObject {
	boolean isUse = false;

	@Override
	public void Start(MainPanel mainPanel) {
		isInnerWindow = false;
		radius = 10;
	}

	@Override
	public void Update(MainPanel mainPanel) {
		if(isUse) {
			if(IsInside() == false) {
				isUse = false;
				moveDirection.setLocation(0, 0);
			}
		}
	}

	@Override
	public void Display(Graphics g) {
		if(isUse) {
			g.setColor(color);
			g.fillOval((int)position.x - 5, (int)position.y - 5, 10, 10);
		}
	}
}
