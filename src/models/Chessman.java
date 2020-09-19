package models;


public abstract class Chessman
{

  protected Square position;

  protected String color;

  protected String name;

  protected boolean haveModed;


  public Chessman(Square position, String color, String name)
  {
    this.position  = position;
    this.color     = color;
    this.name      = name;
    this.haveModed = false;
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

    this.position  = newPosition;
    this.haveModed = true;
  }



  public abstract boolean canMoveTo(Square destination, Board game);
}
