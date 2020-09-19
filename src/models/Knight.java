package models;

import models.Chessman;


public class Knight extends Chessman
{

  public static final int LEFT_ROW = 2;

  public static final int RIGHT_ROW = 5;


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
