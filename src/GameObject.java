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

	abstract public void Start(MainPanel mainPanel);
	abstract public void Update(MainPanel mainPanel);
	abstract public void Display(Graphics g);

	public void MovementUpdate(MainPanel mainPanel) {
		position.x += moveDirection.x;
		position.y += moveDirection.y;
		if(isInnerWindow) {
			if(position.x < Width()) {
				position.x = Width();
			} else if(position.x > 640 - Width()) {
				position.x = 640 - Width();
			}
			if(position.y < Height()) {
				position.y = Height();
			} else if(position.y > 480 - Height()) {
				position.y = 480 - Height();
			}
		}
	}

	public void Collision(GameObject gameObject) {
	}

	public boolean IsInside() {
		if(position.x < -Width() ||
			position.x > 640 + Width() ||
			position.y < -Height() ||
			position.y > 480 + Height()) {
			return false;
		}

		return true;
	}

	public float Width() {
		return (radius + radius) * scale.x;
	}

	public float Height() {
		return (radius + radius) * scale.y;
	}
}
