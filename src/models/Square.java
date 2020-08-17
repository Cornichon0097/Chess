package models;


public class Square
{

  private byte rank;

  private byte file;

  private Chessman piece;


  public Square(int rank, int file)
  {
    this.rank = (byte) rank;
    this.file = (byte) file;
    this.piece = null;
  }



  public byte getRank()
  {
    return this.rank;
  }



  public byte getFile()
  {
    return this.file;
  }



  public void setPiece(Chessman piece)
  {
    this.piece = piece;
  }



  public Chessman getPiece()
  {
    return this.piece;
  }



  public boolean isTaken()
  {
    if (this.piece == null)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
}
