package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class King extends GamePiece{

    public King(String idString, IntPair loc, String c, Game g){

      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;
      game = g;

    }

    public ArrayList<IntPair> canMoveTo(){

        ArrayList<IntPair> possibleLocations = new ArrayList<>();


        return possibleLocations;

    }

}
