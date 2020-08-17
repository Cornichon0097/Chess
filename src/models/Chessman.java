package models;


public abstract class Chessman
{

  protected Square position;

  protected String color;

  protected String name;

  protected boolean haveMove;


  public Chessman(Square position, String color, String name)
  {
    this.position = position;
    this.color = color;
    this.name = name;
    this.haveMove = false;
  }



  public Square getPosition()
  {
    return this.position;
  }



  public String getColor()
  {
    return this.color;
  }



  public String getName()
  {
    return this.name;
  }



  public void move(Square newPosition)
  {
    newPosition.setPiece(this);
    this.position.setPiece(null);
    this.position = newPosition;
    this.haveMove = true;
  }



  public abstract boolean canMoveTo(Square destination, Board game);
}
