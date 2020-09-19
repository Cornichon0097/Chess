package models;

import models.Chessman;


public class Bishop extends Chessman
{

  public static final int LEFT_ROW = 1;

  public static final int RIGHT_ROW = 6;


  public Bishop(Square position, String color)
  {
    super(position, color, "bishop");
  }


  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {


    return true;
  }
}
