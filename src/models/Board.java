package models;

import models.Square;
import models.Chessman;
import models.King;
import models.Queen;
import models.Rook;
import models.Bishop;
import models.Knight;
import models.Pawn;


public class Board
{

  public static final int ROWS = 8;

  public static final int COLUMNS = 8;

  private Square[][] board;

  private Chessman lastMovedPiece;


  public Board()
  {
    this.board          = new Square[Board.ROWS][Board.COLUMNS];
    this.lastMovedPiece = null;

    for (int i = 0; i < Board.ROWS; i++)
    {
      for (int j = 0; j < Board.COLUMNS; j++)
      {
        this.board[i][j] = new Square(i, j);

        if (i <= Pawn.BLACK_ROW)
        {
          String color = "black";

          if (i == Pawn.BLACK_ROW)
          {
            this.board[i][j].setPiece(new Pawn(this.board[i][j], color));
          }
          else
          {
            this.setPieces(i, j, color);
          }
        }

        if (i >= Pawn.WHITE_ROW)
        {
          String color = "white";

          if (i == Pawn.WHITE_ROW)
          {
            this.board[i][j].setPiece(new Pawn(this.board[i][j], color));
          }
          else
          {
            this.setPieces(i, j, color);
          }
        }
      }
    }
  }



  public void setPieces(int i, int j, String color)
  {
    if (j == King.COLUMN)
    {
      this.board[i][j].setPiece(new King(this.board[i][j], color));
    }

    if (j == Queen.COLUMN)
    {
      this.board[i][j].setPiece(new Queen(this.board[i][j], color));
    }

    if ((j == Rook.LEFT_ROW) || (j == Rook.RIGHT_ROW))
    {
      this.board[i][j].setPiece(new Rook(this.board[i][j], color));
    }

    if ((j == Bishop.LEFT_ROW) || (j == Bishop.RIGHT_ROW))
    {
      this.board[i][j].setPiece(new Bishop(this.board[i][j], color));
    }

    if ((j == Knight.LEFT_ROW) || (j == Knight.RIGHT_ROW))
    {
      this.board[i][j].setPiece(new Knight(this.board[i][j], color));
    }
  }



  public Square getSquare(int i, int j)
  {
    return this.board[i][j];
  }



  public void setLastMovedPiece(Chessman piece)
  {
    this.lastMovedPiece = piece;
  }



  public Chessman getLastMovedPiece()
  {
    return this.lastMovedPiece;
  }
}
