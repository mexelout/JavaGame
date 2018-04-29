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
			float width = radius * scale.x;
			if(position.x < width) {
				position.x = width;
			} else if(position.x > 640 - width) {
				position.x = 640 - width;
		}
		float height = radius * scale.y;
		if(position.y < height) {
			position.y = height;
		} else if(position.y > 480 - height) {
			position.y = 480 - height;
			}
		}
	}

	public void Collision(GameObject gameObject) {
	}
}
