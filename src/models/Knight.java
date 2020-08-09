package models;

import models.Chessman;


public class Knight extends Chessman
{

  public Knight(Square position, String color)
  {
    super(position, color, "knight");
  }


  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {


    return true;
  }
}
