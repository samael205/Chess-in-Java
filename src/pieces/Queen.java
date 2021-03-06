package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class Queen extends GamePiece{

    public Queen(String idString, IntPair loc, String c, Game g){
      super(idString, loc, c, g);
    }

    public ArrayList<IntPair> canMoveTo(){

      ArrayList<IntPair> possibleLocations = new ArrayList<>();
      int i, j;

      i = location.getX();
      j = location.getY();

      while(i < 8){
        if(game.pieceAt(i, location.getY()) != null){
          if(!game.pieceAt(i, location.getY()).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, location.getY()));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(i, location.getY()));
        i++;
      }

      i = location.getX();
      j = location.getY();

      //Move up until collision
      while(j < 8){
        if(game.pieceAt(location.getX(), j) != null){
          if(!game.pieceAt(location.getX(), j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(location.getX(), j));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(location.getX(), j));
        j++;
      }

      i = location.getX();
      j = location.getY();
      //Move left until collision
      while(i >= 0){
        if(game.pieceAt(i, location.getY()) != null){
          if(!game.pieceAt(i, location.getY()).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, location.getY()));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(i, location.getY()));
        i--;
      }

      i = location.getX();
      j = location.getY();
      //Move down until collision
      while(j >= 0){
        if(game.pieceAt(location.getX(), j) != null){
          if(!game.pieceAt(location.getX(), j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(location.getX(), j));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(location.getX(), j));
        j--;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving up and to the right
      while(i < 8 && j < 8){
        if(game.pieceAt(i, j) != null){
          if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, j));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(i, j));
        i++; j++;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving up and to the left
      while(i >= 0 && j < 8){
        if(game.pieceAt(i, j) != null){
          if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, j));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(i, j));
        i--; j++;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving down and to the left
      while(i >= 0 && j >= 0){
        if(game.pieceAt(i, j) != null){
          if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, j));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(i, j));
        i--; j--;
      }

      i = location.getX();
      j = location.getY();

      //add locations moving down and to the right
      while(i < 8 && j >= 0){
        if(game.pieceAt(i, j) != null){
          if(!game.pieceAt(i, j).getColour().equals(this.colour)) {
            possibleLocations.add(new IntPair(i, j));
            break;
          }
          else if(game.pieceAt(i, j).getColour().equals(this.colour) && game.pieceAt(i, j) != this){
            break;
          }
        }
        possibleLocations.add(new IntPair(i, j));
        i++; j--;
      }

      return possibleLocations;
    }

}
