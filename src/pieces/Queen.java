package pieces;

import util.IntPair;

import java.util.ArrayList;

public class Queen extends GamePiece{
    public Queen(IntPair loc, String idString, String c){
      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;
    }
    public ArrayList<IntPair> canMoveTo(){

      while(i < 8 && game.chessBoard[i, location.getY()] == null){
        possibleLocations.add(new IntPair(i, location.getY()));
        i++;
      }

      //Move up until collision
      while(j < 8 && game.chessBoard[location.getX(), j] == null){
        possibleLocations.add(new IntPair(location.getX(), j));
        j++;
      }

      i = location.getX();
      //Move left until collision
      while(i > 0 && game.chessBoard[i, location.getY()] == null){
        possibleLocations.add(new IntPair(i, location.getY()));
        i--;
      }

      j = location.getY();
      //Move down until collision
      while(j > 0 && game.chessBoard[location.getX(), j] == null){
        possibleLocations.add(new IntPair(location.getX(), j));
        j--;
      }

      i = location.getX();
      j = location.getY();

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
