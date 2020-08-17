package controllers;

import models.Board;
import models.Square;

import views.Cell;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class Move implements MouseListener
{

  private Board game;

  private Cell piece;

  private boolean whiteTurn;


  public Move(Board game)
  {
    this.game = game;
    this.piece = null;
    this.whiteTurn = true;
  }



  @Override
  public void mouseClicked(MouseEvent e)
  {
    Cell clicked = (Cell) e.getComponent();
    Square associated = clicked.getSquare();


    if (this.piece == null)
    {
      if (associated.isTaken())
      {
        if ((this.whiteTurn == true) && (associated.getPiece().getColor() == "white"))
        {
          this.piece = clicked;
        }

        if ((this.whiteTurn == false) && (associated.getPiece().getColor() == "black"))
        {
          this.piece = clicked;
        }
      }
    }
    else
    {
      if (associated.isTaken())
      {
        if (this.piece.getSquare().getPiece().getColor()
            == associated.getPiece().getColor())
          {
            return;
          }
      }

      if (this.piece.getSquare().getPiece().canMoveTo(associated, this.game))
      {
        this.piece.getSquare().getPiece().move(associated);
        clicked.repaint();
        piece.repaint();
        this.whiteTurn = !this.whiteTurn;
      }

      this.piece = null;
    }
  }



  @Override
  public void mouseEntered(MouseEvent e) {}



  @Override
  public void mouseExited(MouseEvent e) {}



  @Override
  public void mousePressed(MouseEvent e) {}



  @Override
  public void mouseReleased(MouseEvent e) {}
}
