package models;

import models.Chessman;


public class Pawn extends Chessman
{

  public Pawn(Square position, String color)
  {
    super(position, color, "pawn");
  }



  public int getDifference()
  {
    return this.difference;
  }



  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {
    int difference;


    if (this.color == "white")
    {
      if (this.position.getRank() <= newPosition.getRank())
      {
        return false;
      }

      difference = this.position.getRank() - newPosition.getRank();
    }
    else /* if (this.color == "black") */
    {
      if (this.position.getRank() >= newPosition.getRank())
      {
        return false;
      }

      difference = newPosition.getRank() - this.position.getRank();
    }

    if (difference > 2)
    {
      return false;
    }

    if ((difference > 1) && (this.haveMove))
    {
      return false;
    }

    if (this.position.getFile() != newPosition.getFile())
    {
      if (difference != 1)
      {
        return false;
      }

      if (!game.getSquare(newPosition.getRank(), newPosition.getFile()).isTaken())
      {
        return false;
      }
    }


    return true;
  }
}
