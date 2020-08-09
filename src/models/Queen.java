package models;

import models.Chessman;


public class Queen extends Chessman
{

  public Queen(Square position, String color)
  {
    super(position, color, "queen");
  }


  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {


    return true;
  }
}
