package models;


public abstract class Chessman
{

  protected Square position;

  protected String color;

  protected String name;


  public Chessman(Square position, String color, String name)
  {
    this.position = position;
    this.color = color;
    this.name = name;
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
  }

  public abstract boolean canMoveTo(Square destination, Board game);
}
