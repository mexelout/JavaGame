import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public class Shot extends GameObject {
	public boolean fire = false;
	private float bulletRate = 0;

	@Override
	public void Start(MainPanel mainPanel) {
	}

	@Override
	public void Update(MainPanel mainPanel) {
		fire = mainPanel.keys.get(KeyEvent.VK_SPACE);
		// bullet fire processing
		if(fire && bulletRate <= 0) {
			bulletRate = 10;
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
		bulletRate -= (bulletRate > 0) ? 1 : 0;
	}

	@Override
	public void Display(Graphics g) {
	}
}
