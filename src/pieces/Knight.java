package pieces;

import util.IntPair;

import java.util.ArrayList;

public class Knight extends GamePiece{

    public Knight(String idString, IntPair loc, String c){

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
      boolean collision;

      i = location.getX();
      j = location.getY();

      //if()

      return possibleLocations;
    };

}
