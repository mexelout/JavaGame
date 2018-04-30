import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public class Shot extends GameObject {
	public boolean fire = false;
	private float fireRate = 0;

	@Override
	public void start(MainPanel mainPanel) {
	}

	@Override
	public void update(MainPanel mainPanel) {
		fire = mainPanel.keys.get(KeyEvent.VK_SPACE);
		// bullet fire processing
		if(fire && fireRate <= 0) {
			fireRate = 10;
			for(Bullet bullet : mainPanel.playerBullets) {
				if(bullet.isUse == false) {
					bullet.isUse = true;
					bullet.position = (Point2D.Float)mainPanel.player.position.clone();
					bullet.moveDirection.x = (float)Math.sin(Math.toRadians(mainPanel.player.angle)) * 5;
					bullet.moveDirection.y = (float)Math.cos(Math.toRadians(mainPanel.player.angle)) * 5;
					break;
				}
			}
		}
		fireRate -= (fireRate > 0) ? 1 : 0;
	}

	@Override
	public void display(Graphics g) {
	}
}
