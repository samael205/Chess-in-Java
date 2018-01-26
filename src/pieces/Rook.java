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

        if(colour.equals("white")){
          //Go through all x values until a collision occurs, add all locations where there is no collision
          while(i < 8 && game.chessBoard[i, location.getY()] == null){
            possibleLocations.add(new IntPair(i, location.getY()));
            i++;
          }

          //Go through all y values until a collision occurs, add all locations where there is no collision
          while(j < 8 && game.chessBoard[location.getX(), j] == null){
            possibleLocations.add(new IntPair(location.getX(), j));
            j++;
          }
        }
        else{
          while(i > 0 && game.chessBoard[i, location.getY()] == null){
            possibleLocations.add(new IntPair(i, location.getY()));
            i--;
          }

          //Go through all y values until a collision occurs, add all locations where there is no collision
          while(j > 0 && game.chessBoard[location.getX(), j] == null){
            possibleLocations.add(new IntPair(location.getX(), j));
            j--;
          }
        }

        return possibleLocations;
    }
    public boolean moveTo(){
        return false;
    };
}
