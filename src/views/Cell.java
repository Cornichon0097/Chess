package views;

import models.Square;

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Color;


public class Cell extends JComponent
{

  private Square square;


  public Cell(Square square)
  {
    super();
    this.square = square;
  }



  @Override
  public void paintComponent(Graphics g)
  {
    Graphics g2 = g.create();


    if (this.isOpaque())
    {
      g2.setColor(this.getBackground());
      g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    if (((this.square.getRank() + this.square.getFile()) % 2) == 0)
    {
      g2.setColor(new Color(0xFDE9E0));
    }
    else
    {
      g2.setColor(new Color(0xA76726));
    }

    g2.fillRect(0, 0, this.getWidth(), this.getHeight());

    if (this.square.isTaken())
    {
      g2.drawImage(Toolkit.getDefaultToolkit().getImage("../img/chessmen/"
                   + this.square.getPiece().getColor() + "/"
                   + this.square.getPiece().getName() + ".png"), 0, 0, this);
    }
  }



  public Square getSquare()
  {
    return this.square;
  }
}
