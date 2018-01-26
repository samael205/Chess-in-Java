package pieces;

import util.IntPair;

import java.util.ArrayList;

public class Queen extends GamePiece{

    public Queen(IntPair loc, String idString, String c){

      location = loc;
      id = idString;
      colour = c;
      hasMoved = false;
      isThreatening = false;
      taken = false;
      
    }

    public ArrayList<IntPair> canMoveTo(){

      ArrayList<IntPair> possibleLocations = new ArrayList<IntPair>();
      boolean collision;
      int i, j;

      i = location.getX();
      j = location.getY();
      collision = false;

      while(i < 8) && !collision){
        if(game.chessBoard[i, location.getY()] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(i, location.getY()));
        i++;
      }

      collision = false;

      //Move up until collision
      while(j < 8 && !collision){
        if(game.chessBoard[getX(), j] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(location.getX(), j));
        j++;
      }

      collision = false;
      i = location.getX();
      //Move left until collision
      while(i > 0 && !collision){
        if(game.chessBoard[i, location.getY()] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(i, location.getY()));
        i--;
      }

      collision = false;
      j = location.getY();
      //Move down until collision
      while(j > 0 && !collision){
        if(game.chessBoard[getX(), j] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(location.getX(), j));
        j--;
      }

      i = location.getX();
      j = location.getY();
      collision = false;

      //add locations moving up and to the right
      while(i < 8 && j < 8 && !collision){
        if(game.chessBoard[i, j] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(i, j));
        i++; j++;
      }

      i = location.getX();
      j = location.getY();
      collision = false;

      //add locations moving up and to the left
      while(i > 0 && j < 8 && !collision){
        if(game.chessBoard[i, j] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(i, j));
        i--; j++;
      }

      i = location.getX();
      j = location.getY();
      collision = false;

      //add locatinos moving down and to the left
      while(i > 0 && j > 0 && !collision){
        if(game.chessBoard[i, j] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(i, j));
        i--; j--;
      }

      i = location.getX();
      j = location.getY();
      collision = false;

      //add locations moving down and to the right
      while(i < 8 && j > 0 && !collision){
        if(game.chessBoard[i, j] != null){
           collision = true;
        }
        possibleLocations.add(new IntPair(i, j));
        i++; j--;
      }

      return possibleLocations;
    };

}
