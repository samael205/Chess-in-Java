package pieces;

import util.IntPair;

import java.util.ArrayList;

public class Bishop extends GamePiece{
    public Bishop(IntPair loc, String idString, String c){
      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;
    }
    public ArrayList<IntPair> canMoveTo(){

      ArrayList<IntPair> possibleLocations = new ArrayList<IntPair>();
      int i, j;

      i = location.getX();
      j = location.getY();

      //Code for bishops is the same for black and white

      //add locations moving up and to the right
      while(i < 8 && j < 8 && game.chessBoard[i, j] == null){
        possibleLocations.add(new IntPair(i, j));
        i++; j++;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving up and to the left
      while(i > 0 && j < 8 && game.chessBoard[i, j] == null){
        possibleLocations.add(new IntPair(i, j));
        i--; j++;
      }

      i = location.getX();
      j = location.getY();

      //add locatinos moving down and to the left
      while(i > 0 && j > 0 && game.chessBoard[i, j] == null){
        possibleLocations.add(new IntPair(i, j));
        i--; j--;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving down and to the right
      while(i < 8 && j > 0 && game.chessBoard[i, j] == null){
        possibleLocations.add(new IntPair(i, j));
        i++; j--;
      }

      return possibleLocations;

    };
}
