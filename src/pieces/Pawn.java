package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class Pawn extends GamePiece{

    public Pawn(String idString, IntPair loc, String c, Game g){

      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;
      game = g;
      
    }

    public ArrayList<IntPair> canMoveTo(){


      //IMPORTANT: This does not yet implement the ability for pawn's to take
      //pieces (ie move diagonally)

      ArrayList<IntPair> possibleLocations = new ArrayList<>();
      //int i, j;

      if(colour.equals("black")){
        //Check if the square in front of the pawn is occupied.


        if(location.getY() + 1 < 8 && game.pieceAt(location.getX(), location.getY() + 1) == null){
          possibleLocations.add(new IntPair(location.getX(), location.getY() + 1));

          //Pawns can move an extra square on their first move
          if(!hasMoved && game.pieceAt(location.getX(), location.getY() + 2) == null){
            possibleLocations.add(new IntPair(location.getX(), location.getY() + 2));
          }
        }
      }
      else{ //for white pawns
        if(location.getY() - 1 > 0 && game.pieceAt(location.getX(), location.getY() - 1) == null){
          possibleLocations.add(new IntPair(location.getX(), location.getY() - 1));

          //Pawns can move an extra square on their first move
          if(!hasMoved && game.pieceAt(location.getX(), location.getY() - 2) == null){
            possibleLocations.add(new IntPair(location.getX(), location.getY() - 2));
          }
        }

      }
      return possibleLocations;

    }
}
