package models;

import models.Chessman;


public class King extends Chessman
{

  public static final int COLUMN = 4;


  public King(Square position, String color)
  {
    super(position, color, "king");
  }


  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {


    return true;
  }
}
