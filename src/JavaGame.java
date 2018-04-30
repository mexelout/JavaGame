import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class JavaGame extends JFrame {
	public static void main(String[] args) {
		JavaGame frame = new JavaGame("JavaGame");
		frame.setVisible(true);
	}

	JavaGame(String title) {
		setTitle(title);
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(640, 480));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mp = new MainPanel();
		cp.add(mp);
		addKeyListener(mp);
	}
}
