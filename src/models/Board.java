package models;

import models.Square;


public class Board
{

  private Square[][] board;


  public Board()
  {
    this.board = new Square[8][8];

    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        this.board[i][j] = new Square(i, j);

        if (i < 2)
        {
          String color = "black";

          if (i == 1)
          {
            this.board[i][j].setPiece(new Pawn(this.board[i][j], color));
          }
          else
          {
            this.setPieces(i, j, color);
          }
        }

        if (i > 5)
        {
          String color = "white";

          if (i == 6)
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
    if ((j == 0) || (j == 7))
    {
      this.board[i][j].setPiece(new Rook(this.board[i][j], color));
    }

    if ((j == 1) || (j == 6))
    {
      this.board[i][j].setPiece(new Bishop(this.board[i][j], color));
    }

    if ((j == 2) || (j == 5))
    {
      this.board[i][j].setPiece(new Knight(this.board[i][j], color));
    }

    if (j == 3)
    {
      this.board[i][j].setPiece(new Queen(this.board[i][j], color));
    }

    if (j == 4)
    {
      this.board[i][j].setPiece(new King(this.board[i][j], color));
    }
  }



  public Square getSquare(int i, int j)
  {
    return this.board[i][j];
  }
}
