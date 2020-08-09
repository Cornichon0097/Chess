package models;

import models.Chessman;


public class Bishop extends Chessman
{

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
