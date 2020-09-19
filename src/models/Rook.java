package models;

import models.Board;
import models.Square;
import models.Chessman;


public class Rook extends Chessman
{

  public static final int LEFT_ROW = 0;

  public static final int RIGHT_ROW = 7;


  public Rook(Square position, String color)
  {
    super(position, color, "rook");
  }



  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {
    if ((this.position.getRank() != newPosition.getRank())
        && (this.position.getFile() != newPosition.getFile()))
    {
      return false;
    }

    for (int i = this.position.getRank(); i != newPosition.getRank();)
    {
      if (this.position.getRank() < newPosition.getRank())
      {
        i++;
      }
      else
      {
        i--;
      }

      if ((game.getSquare(i, newPosition.getFile()).isTaken())
          && (i != newPosition.getRank()))
      {
        return false;
      }
    }

    for (int i = this.position.getFile(); i != newPosition.getFile();)
    {
      if (this.position.getFile() < newPosition.getFile())
      {
        i++;
      }
      else
      {
        i--;
      }

      if ((game.getSquare(newPosition.getRank(), i).isTaken())
          && (i != newPosition.getFile()))
      {
        return false;
      }
    }


    return true;
  }
}
