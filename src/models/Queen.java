package models;

import models.Chessman;


public class Queen extends Chessman
{

  public static final int COLUMN = 3;


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
