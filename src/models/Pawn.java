package models;

import models.Board;
import models.Square;
import models.Chessman;


public class Pawn extends Chessman
{

  public static final String NAME = "pawn";

  public static final int BLACK_ROW = 1;

  public static final int WHITE_ROW = 6;

  private int difference;


  public Pawn(Square position, String color)
  {
    super(position, color, Pawn.NAME);

    this.difference = 0;
  }



  public int getDifference()
  {
    return this.difference;
  }



  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {
    if (this.color == "white")
    {
      if (this.position.getRank() <= newPosition.getRank())
      {
        return false;
      }

      this.difference = this.position.getRank() - newPosition.getRank();
    }
    else /* if (this.color == "black") */
    {
      if (this.position.getRank() >= newPosition.getRank())
      {
        return false;
      }

      this.difference = newPosition.getRank() - this.position.getRank();
    }

    if (this.difference > 2)
    {
      return false;
    }

    if ((this.difference > 1) && (this.haveModed))
    {
      return false;
    }

    if (this.position.getFile() != newPosition.getFile())
    {
      if (this.difference != 1)
      {
        return false;
      }

      if (!game.getSquare(newPosition.getRank(), newPosition.getFile()).isTaken()
          && !(game.getSquare(this.position.getRank(), newPosition.getFile()).isTaken()
               && game.getSquare(this.position.getRank(), newPosition.getFile())
                  .getPiece().getName() == Pawn.NAME
               && game.getSquare(this.position.getRank(), newPosition.getFile())
                  .getPiece() == game.getLastMovedPiece()))
      {
        return false;
      }
    }


    return true;
  }
}
