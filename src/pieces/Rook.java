package pieces;

import util.IntPair;

import java.util.ArrayList;

public class Rook extends GamePiece{
    public Rook(IntPair loc, String idString, String c){
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


        //Move right until collision
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


        return possibleLocations;
    }
    public boolean moveTo(){
      hasMoved = true;
        return false;
    };
}
