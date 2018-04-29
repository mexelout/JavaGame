import java.awt.Container;

import javax.swing.JFrame;

public class JavaGame extends JFrame {
  public static void main(String[] args) {
    JavaGame frame = new JavaGame("JavaGame");
    frame.setVisible(true);
  }

  JavaGame(String title) {
    setTitle(title);
    setSize(640, 480);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = getContentPane();
    MainPanel mp = new MainPanel();
    cp.add(mp);
    addKeyListener(mp);
  }
}
