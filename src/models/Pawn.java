package models;

import models.Chessman;


public class Pawn extends Chessman
{

  public Pawn(Square position, String color)
  {
    super(position, color, "pawn");
  }


  @Override
  public boolean canMoveTo(Square newPosition, Board game)
  {


    return true;
  }
}
