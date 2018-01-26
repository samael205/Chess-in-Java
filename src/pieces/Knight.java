package pieces;

import util.IntPair;

import java.util.ArrayList;

public class Knight extends GamePiece{
    public Knight(IntPair loc, String idString, String c){
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
