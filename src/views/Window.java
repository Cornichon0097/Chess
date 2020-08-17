package views;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class Window extends JFrame
{

  protected JPanel display;


  public Window(int x, int y, int width, int heigth, String title)
  {
    super(title);

    this.setLocation(x, y);
    this.setSize(width, heigth);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.display = new JPanel();
    this.display.setLayout(null);
    this.add(this.display);
  }
}
