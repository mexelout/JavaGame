import java.awt.Color;
import java.awt.Graphics;

import math.Vector2D;

public abstract class GameObject {
	// transform
	public Vector2D position;
	public Vector2D scale;
	public float angle = 0;

	// charactor controlle parameters
	public Vector2D moveDirection;
	protected boolean isInnerWindow = true;
	public float radius = 1;
	protected boolean isKinematic = false;
	protected GameObject isHitObject;

	// material
	Color color;

	GameObject() {
		position = new Vector2D(0, 0);
		scale = new Vector2D(1, 1);
		moveDirection = new Vector2D(0, 0);
	}

	abstract public void start(MainPanel mainPanel);
	abstract public void update(MainPanel mainPanel);
	abstract public void display(Graphics g);

	public void movementUpdate(MainPanel mainPanel) {
		position.x += moveDirection.x;
		position.y += moveDirection.y;
		if(isInnerWindow) {
			float halfWidth = width() / 2;
			float halfHeight = height() / 2;
			if(position.x < halfWidth) {
				position.x = halfWidth;
			} else if(position.x > 640 - halfWidth) {
				position.x = 640 - halfWidth;
			}
			if(position.y < halfHeight) {
				position.y = halfHeight;
			} else if(position.y > 480 - halfHeight) {
				position.y = 480 - halfHeight;
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

	public Vector2D front() {
		return new Vector2D(
			(float)Math.sin(Math.toRadians(angle)),
			(float)Math.cos(Math.toRadians(angle))
		);
	}
}
