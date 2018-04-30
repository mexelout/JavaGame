import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public abstract class GameObject {
	// transform
	public Point2D.Float position;
	public Point2D.Float scale;
	public float angle = 0;

	// charactor controlle parameters
	public Point2D.Float moveDirection;
	protected boolean isInnerWindow = true;
	public float radius = 1;
	protected boolean isKinematic = false;
	protected GameObject isHitObject;

	// material
	Color color;

	GameObject() {
		position = new Point2D.Float(0, 0);
		scale = new Point2D.Float(1, 1);
		moveDirection = new Point2D.Float(0, 0);
	}

	abstract public void start(MainPanel mainPanel);
	abstract public void update(MainPanel mainPanel);
	abstract public void display(Graphics g);

	public void movementUpdate(MainPanel mainPanel) {
		position.x += moveDirection.x;
		position.y += moveDirection.y;
		if(isInnerWindow) {
			if(position.x < width()) {
				position.x = width();
			} else if(position.x > 640 - width()) {
				position.x = 640 - width();
			}
			if(position.y < height()) {
				position.y = height();
			} else if(position.y > 480 - height()) {
				position.y = 480 - height();
			}
		}
	}

	public void collision(GameObject gameObject) {
	}

	public boolean isInside() {
		if(position.x < -width() ||
			position.x > 640 + width() ||
			position.y < -height() ||
			position.y > 480 + height()) {
			return false;
		}

		return true;
	}

	public float width() {
		return (radius + radius) * scale.x;
	}

	public float height() {
		return (radius + radius) * scale.y;
	}
}
