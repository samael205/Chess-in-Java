package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class Pawn extends GamePiece{

    public Pawn(String idString, IntPair loc, String c, Game g){
     super(idString, loc, c, g);
    }

    public ArrayList<IntPair> canMoveTo(){


      //IMPORTANT: This does not yet implement the ability for pawn's to take
      //pieces (ie move diagonally)

      ArrayList<IntPair> possibleLocations = new ArrayList<>();
      //int i, j;

      if(colour.equals("black")){
        //Check if the square in front of the pawn is occupied.
          // logic for pawns taking pieces
        if(location.getY() + 1 < 8 && location.getX() - 1 >= 0) {
          GamePiece piece = game.pieceAt(location.getX() - 1, location.getY() + 1);
          if(piece != null) {
            if (!piece.colour.equals(this.colour)) {
              possibleLocations.add(new IntPair(location.getX() - 1, location.getY() + 1));
            }
          }
        }
        if(location.getY() + 1 < 8 && location.getX() + 1 < 8){
          GamePiece piece = game.pieceAt(location.getX() + 1, location.getY() + 1);
          if(piece != null) {
            if (!piece.colour.equals(this.colour)) {
              possibleLocations.add(new IntPair(location.getX() + 1, location.getY() + 1));
            }
          }
        }
        if(location.getY() + 1 < 8 && game.pieceAt(location.getX(), location.getY() + 1) == null){
          possibleLocations.add(new IntPair(location.getX(), location.getY() + 1));

          //Pawns can move an extra square on their first move
          if(location.getY() + 2 < 8 && !hasMoved && game.pieceAt(location.getX(), location.getY() + 2) == null){
            possibleLocations.add(new IntPair(location.getX(), location.getY() + 2));
          }
        }
      }
      else{ //for white pawns

        if(location.getY() - 1 >= 0 && location.getX() - 1 >= 0) {
          GamePiece piece = game.pieceAt(location.getX() - 1, location.getY() - 1);
          if(piece != null) {
            if (!piece.colour.equals(this.colour)) {
              possibleLocations.add(new IntPair(location.getX() - 1, location.getY() - 1));
            }
          }
        }
        if(location.getY() - 1 >= 0 && location.getX() + 1 < 8){
          GamePiece piece = game.pieceAt(location.getX() + 1, location.getY() - 1);
          if(piece != null) {
            if (!piece.colour.equals(this.colour)) {
              possibleLocations.add(new IntPair(location.getX() + 1, location.getY() - 1));
            }
          }
        }
        if(location.getY() - 1 > 0 && game.pieceAt(location.getX(), location.getY() - 1) == null){

          possibleLocations.add(new IntPair(location.getX(), location.getY() - 1));

          //Pawns can move an extra square on their first move
          if(location.getY() - 2 > 0 &&!hasMoved && game.pieceAt(location.getX(), location.getY() - 2) == null){
            possibleLocations.add(new IntPair(location.getX(), location.getY() - 2));
          }
        }

      }
      return possibleLocations;

    }
}
