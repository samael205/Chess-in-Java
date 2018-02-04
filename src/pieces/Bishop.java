package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class Bishop extends GamePiece{

    public Bishop(String idString, IntPair loc, String c, Game g){

      super(idString, loc, c, g);
      
    }

    public ArrayList<IntPair> canMoveTo(){

      ArrayList<IntPair> possibleLocations = new ArrayList<>();
      int i, j;

      i = location.getX();
      j = location.getY();
      //Code for bishops is the same for black and white

      //add locations moving up and to the right
      while(i < 8 && j < 8){
        if(game.pieceAt(i, j) != null){
          if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, j));
          }
          break;
        }
        possibleLocations.add(new IntPair(i, j));
        i++; j++;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving up and to the left
      while(i > 0 && j < 8){
        if(game.pieceAt(i, j) != null){
          if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, j));
          }
          break;
        }
        possibleLocations.add(new IntPair(i, j));
        i--; j++;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving down and to the left
      while(i > 0 && j > 0){
        if(game.pieceAt(i, j) != null){
           if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
             possibleLocations.add(new IntPair(i, j));
           }
           break;
        }
        possibleLocations.add(new IntPair(i, j));
        i--; j--;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving down and to the right
      while(i < 8 && j > 0){
        if(game.pieceAt(i, j) != null){
          if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, j));
          }
          break;
        }
        possibleLocations.add(new IntPair(i, j));
        i++; j--;
      }

      return possibleLocations;

    }
}
