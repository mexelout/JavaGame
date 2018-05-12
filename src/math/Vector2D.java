package math;

public class Vector2D {
	public float x, y;
	public Vector2D() {}
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public Vector2D zero() {
		x = 0;
		y = 0;
		return this;
	}
	public Vector2D clone() {
		return new Vector2D(x, y);
	}
	public Vector2D set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	public Vector2D add(Vector2D vec) {
		return new Vector2D(x + vec.x, y + vec.y);
	}
	public Vector2D addEq(Vector2D vec) {
		x += vec.x;
		y += vec.y;
		return this;
	}
	public Vector2D add(float x, float y) {
		return new Vector2D(this.x + x, this.y + y);
	}
	public Vector2D addEq(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	public Vector2D sub(Vector2D vec) {
		return new Vector2D(x - vec.x, y - vec.y);
	}
	public Vector2D subEq(Vector2D vec) {
		x -= vec.x;
		y -= vec.y;
		return this;
	}
	public Vector2D sub(float x, float y) {
		return new Vector2D(this.x - x, this.y - y);
	}
	public Vector2D subEq(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	public Vector2D mul(float l) {
		return new Vector2D(x * l, y * l);
	}
	public Vector2D mulEq(float l) {
		this.x *= l;
		this.y *= l;
		return this;
	}
	public Vector2D div(float n) {
		return new Vector2D(x / n, y / n);
	}
	public Vector2D divEq(float n) {
		this.x /= n;
		this.y /= n;
		return this;
	}
}
