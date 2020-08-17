package views;

import models.Board;

import views.Window;
import views.Cell;

import controllers.Move;

import java.awt.GridLayout;


public class Chess extends Window
{

  public Chess()
  {
    super(100, 50, 360, 380, "Chess");

    Board board = new Board();
    Move mover = new Move(board);


    this.display.setLayout(new GridLayout(8, 8));

    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        Cell cell = new Cell(board.getSquare(i, j));
        cell.addMouseListener(mover);
        this.display.add(cell);
      }
    }
  }
}
