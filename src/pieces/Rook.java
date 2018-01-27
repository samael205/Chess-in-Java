package pieces;

import util.IntPair;

import java.util.ArrayList;

public class Rook extends GamePiece{
  
    public Rook(String idString, IntPair loc, String c){

      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;

    }

    public ArrayList<IntPair> canMoveTo(){

        ArrayList<IntPair> possibleLocations = new ArrayList<>();
        int i, j;
        boolean collision;

        i = location.getX();
        j = location.getY();

        //Move right until collision
        collision = false;

        while(i < 8 && !collision){
          if(game.pieceAt(i, location.getY()) != null){
             collision = true;
          }
          possibleLocations.add(new IntPair(i, location.getY()));
          i++;
        }

        collision = false;

        //Move up until collision
        while(j < 8 && !collision){
          if(game.pieceAt(location.getX(), j) != null){
             collision = true;
          }
          possibleLocations.add(new IntPair(location.getX(), j));
          j++;
        }

        collision = false;
        i = location.getX();
        //Move left until collision
        while(i > 0 && !collision){
          if(game.pieceAt(i, location.getY()) != null){
             collision = true;
          }
          possibleLocations.add(new IntPair(i, location.getY()));
          i--;
        }

        collision = false;
        j = location.getY();
        //Move down until collision
        while(j > 0 && !collision){
          if(game.pieceAt(location.getX(), j) != null){
             collision = true;
          }
          possibleLocations.add(new IntPair(location.getX(), j));
          j--;
        }

        return possibleLocations;
    };

}
