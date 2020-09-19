package views;

import models.Board;

import views.Window;
import views.Cell;

import controllers.Move;

import java.awt.GridLayout;


public class Chess extends Window
{

  private static final int X = 100;

  private static final int Y = 50;

  private static final int WIDTH = 360;

  private static final int HEIGHT = 380;


  public Chess()
  {
    super(Chess.X, Chess.Y, Chess.WIDTH, Chess.HEIGHT, "Chess");

    Board board = new Board();
    Move  mover = new Move(board);

    this.display.setLayout(new GridLayout(Board.ROWS, Board.COLUMNS));

    for (int i = 0; i < Board.ROWS; i++)
    {
      for (int j = 0; j < Board.COLUMNS; j++)
      {
        Cell cell = new Cell(board.getSquare(i, j));
        cell.addMouseListener(mover);
        this.display.add(cell);
      }
    }
  }
}
