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
        return null;
    }
    public boolean moveTo(){
        return false;
    };
}
