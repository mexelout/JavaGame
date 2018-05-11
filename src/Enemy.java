import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public class Enemy extends GameObject {
	@Override
	public void Start(MainPanel mainPanel) {
		radius = 20;
		color = Color.RED;
	}

	@Override
	public void Update(MainPanel mainPanel) {
	}

	@Override
	public void Display(Graphics g) {
	}
}
