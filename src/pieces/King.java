package pieces;

import util.IntPair;

import java.util.ArrayList;

public class King extends GamePiece{

    public King(String idString, IntPair loc, String c){

      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;
      
    }

    public ArrayList<IntPair> canMoveTo(){
        return null;
    };

}
