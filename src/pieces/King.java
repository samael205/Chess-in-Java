package pieces;

import util.intPair;

import java.util.ArrayList;

public class King extends GamePiece{
    public King(intPair loc, String idString, String c){
      location = loc;
      id = idString;
      colour = c;
    }
    public ArrayList<intPair> canMoveTo(){
        return null;
    }
    public boolean moveTo(){
        return false;
    };
}
