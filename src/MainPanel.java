import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable, KeyListener {
	public ArrayList<GameObject> gameObjects = new ArrayList<>();
	public Player player;
	public Shot shot;
	public Bullet[] playerBullets = new Bullet[100];
	public Map<Integer, Boolean> keys = new HashMap<>();
	public Enemy[] enemies = new Enemy[100];

	private Thread t;

	MainPanel() {
		setBackground(Color.BLUE);
		keys.put(KeyEvent.VK_A, false);
		keys.put(KeyEvent.VK_D, false);
		keys.put(KeyEvent.VK_W, false);
		keys.put(KeyEvent.VK_S, false);
		keys.put(KeyEvent.VK_SPACE, false);
		player = new Player();
		gameObjects.add(player);
		shot = new Shot();
		gameObjects.add(shot);
		Color[] cols = { Color.RED, Color.GREEN, Color.CYAN };
		for(int i = 0; i < 100; ++i) {
			playerBullets[i] = new Bullet();
			playerBullets[i].color = cols[i % 3];
			gameObjects.add(playerBullets[i]);
		}
		for(int i = 0; i < 100; ++i) {
			enemies[i] = new Enemy();
			gameObjects.add(enemies[i]);
		}
		for(GameObject gameObject : gameObjects) {
			gameObject.start(this);
		}

		t = new Thread(this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 640, 480);
		for(GameObject gameObject : gameObjects) {
			gameObject.display(g);
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
			for(GameObject gameObject : gameObjects) {
				gameObject.update(this);
				gameObject.movementUpdate(this);
				for(GameObject otherGameObject : gameObjects) {
					gameObject.collision(otherGameObject);
				}
			}

			// wait 60 fps
			try {
			  Thread.sleep(16);
			} catch(InterruptedException e) {}

			repaint();
		}
	}
}
