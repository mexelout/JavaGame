import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable, KeyListener {
	public Player player = new Player();
	public Map<Integer, Boolean> keys = new HashMap<>();

	public boolean fire = false;
	public float[] bulletX = new float[100], bulletY = new float[100];
	public float[] bulletMoveX = new float[100], bulletMoveY = new float[100];
	public boolean[] bulletUse = new boolean[100];
	public int bulletRate = 0;

	public float[] enemyX = new float[100], enemyY = new float[100];
	public float[] enemyMoveX = new float[100], enemyMoveY = new float[100];
	public boolean[] enemyUse = new boolean[100];
	public int enemyRate = 0;

	private Thread t;

	MainPanel() {
		setBackground(Color.BLUE);
		keys.put(KeyEvent.VK_A, false);
		keys.put(KeyEvent.VK_D, false);
		keys.put(KeyEvent.VK_W, false);
		keys.put(KeyEvent.VK_S, false);
		keys.put(KeyEvent.VK_SPACE, false);
		player.Start(this);
		t = new Thread(this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, 640, 480);
		player.Display(g);

		g.setColor(Color.GRAY);
		for(int i = 0; i < 100; i++) {
			if(bulletUse[i]) {
				g.fillOval((int)bulletX[i] - 5, (int)bulletY[i] - 5, 10, 10);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys.put(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys.put(e.getKeyCode(), false);
	}

	@Override
	public void run() {
		while(true) {
			player.Update(this);
			player.MovementUpdate(this);
			// player.Collision()

			// bullet fire processing
			if(fire && bulletRate == 0) {
				bulletRate = 10;
				for(int i = 0; i < 100; ++i) {
					if(bulletUse[i] == false) {
						bulletUse[i] = true;
						bulletX[i] = player.position.x;
						bulletY[i] = player.position.y;
						bulletMoveX[i] = (float)Math.sin(Math.toRadians(player.angle)) * 5;
						bulletMoveY[i] = (float)Math.cos(Math.toRadians(player.angle)) * 5;
						break;
					}
				}
			}
			for(int i = 0; i < 100; ++i) {
				if(bulletUse[i]) {
					bulletX[i] += bulletMoveX[i];
					bulletY[i] += bulletMoveY[i];
					if(bulletX[i] > 620 && bulletX[i] < 0) {
						bulletUse[i] = false;
					}
					if(bulletY[i] > 460 && bulletY[i] < 0) {
						bulletUse[i] = false;
					}
				}
			}
			bulletRate -= (bulletRate > 0) ? 1 : 0;

			// refresh
			fire = false;

			// enemy processing
			for(int i = 0; i < 100; i++) {
			}

			// wait 60 fps
			try {
			  Thread.sleep(16);
			} catch(InterruptedException e) {}

			repaint();
		}
	}
}
