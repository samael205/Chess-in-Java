package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class Rook extends GamePiece{
  
    public Rook(String idString, IntPair loc, String c, Game g){
        super(idString, loc, c, g);
    }

    public ArrayList<IntPair> canMoveTo(){

        ArrayList<IntPair> possibleLocations = new ArrayList<>();
        int i, j;

        i = location.getX();
        j = location.getY();

        //Move right until collision

        while(i < 8 ){
          if(game.pieceAt(i, location.getY()) != null && game.pieceAt(i, location.getY()) != this){
            if(!game.pieceAt(i, location.getY()).getColour().equals(this.getColour())){
                possibleLocations.add(new IntPair(i, location.getY()));
            }
            break;
          }
          possibleLocations.add(new IntPair(i, location.getY()));
          i++;
        }

        i = location.getX();
        j = location.getY();


        //Move up until collision
        while(j < 8 ){
          if(game.pieceAt(location.getX(), j) != null && game.pieceAt(location.getX(), j) != this){
              if(!game.pieceAt(location.getX(), j).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX(), j));
              }
              break;
          }

          possibleLocations.add(new IntPair(location.getX(), j));
          j++;
        }


        i = location.getX();
        j = location.getY();

        //Move left until collision
        while(i >= 0){
          if(game.pieceAt(i, location.getY()) != null && game.pieceAt(i, location.getY()) != this){
              if(!game.pieceAt(i, location.getY()).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(i, location.getY()));
              }
              break;
          }

          possibleLocations.add(new IntPair(i, location.getY()));
          i--;
        }

        i = location.getX();
        j = location.getY();

        //Move down until collision
        while(j >= 0 ){
          if(game.pieceAt(location.getX(), j) != null && game.pieceAt(location.getX(), j) != this){
              if(!game.pieceAt(location.getX(), j).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX(), j));
              }
              break;
          }
          possibleLocations.add(new IntPair(location.getX(), j));
          j--;
        }

        return possibleLocations;
    }

}
