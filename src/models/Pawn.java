package models;

import models.Chessman;


public class Pawn extends Chessman
{

  private int difference;


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

    if ((this.difference > 1) && (this.haveMove))
    {
      return false;
    }

    if (this.position.getFile() != newPosition.getFile())
    {
      if (this.difference != 1)
      {
        return false;
      }

      if (!game.getSquare(newPosition.getRank(), newPosition.getFile()).isTaken())
      {
        // Square corner = game.getSquare(this.position.getRank(), newPosition.getFile());
        //
        // if ((corner.isTaken()) && (corner.getPiece().getName() == "pawn")
        //       && (((Pawn) corner.getPiece()).getDifference() == 2))
        // {
        //   corner.setPiece(null);
        // }
        // else
        // {
        //   return false;
        // }
        return false;
      }
    }


    return true;
  }
}
