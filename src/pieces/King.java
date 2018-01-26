package pieces;

import util.IntPair;

import java.util.ArrayList;

public class King extends GamePiece{
    public King(IntPair loc, String idString, String c){
      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;
    }
    public ArrayList<IntPair> canMoveTo(){
        return null;
    }
    public boolean moveTo(){
        return false;
    };
}
