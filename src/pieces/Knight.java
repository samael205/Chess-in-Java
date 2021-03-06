package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class Knight extends GamePiece{

    public Knight(String idString, IntPair loc, String c, Game g){
        super(idString, loc, c, g);
    }

    public ArrayList<IntPair> canMoveTo(){

      ArrayList<IntPair> possibleLocations = new ArrayList<>();

      //Check all 8 possible moves for a Knight.
      //There has GOT to be a better way to do this...

      if(location.getX() - 2 > -1 && location.getY() - 1 > -1){
          if(game.pieceAt(location.getX() - 2, location.getY() - 1) == null){
              possibleLocations.add(new IntPair(location.getX() - 2, location.getY() - 1));
          }
          else{
              if(!game.pieceAt(location.getX() - 2, location.getY() - 1).getColour().equals(this.getColour())){
                    possibleLocations.add(new IntPair(location.getX() - 2, location.getY() - 1));
              }
          }
      }
      if(location.getX() - 1 > -1 && location.getY() - 2 >  -1){
          if(game.pieceAt(location.getX() - 1, location.getY() - 2) == null){
              possibleLocations.add(new IntPair(location.getX() - 1, location.getY() - 2));
          }
          else{
              if(!game.pieceAt(location.getX() - 1, location.getY() - 2).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX() - 1, location.getY() - 2));
              }
          }
      }
      if(location.getX() + 1 < 8 && location.getY() - 2 > -1){
          if(game.pieceAt(location.getX() + 1, location.getY() - 2) == null){
              possibleLocations.add(new IntPair(location.getX() + 1, location.getY() - 2));
          }
          else{
              if(!game.pieceAt(location.getX() + 1, location.getY() - 2).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX() + 1, location.getY() - 2));
              }
          }
      }
      if(location.getX() + 2 < 8 && location.getY() - 1 > -1){
          if(game.pieceAt(location.getX() + 2, location.getY() - 1) == null){
              possibleLocations.add(new IntPair(location.getX() + 2, location.getY() - 1));
          }
          else{
              if(!game.pieceAt(location.getX() + 2, location.getY() - 1).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX() + 2, location.getY() - 1));
              }
          }
      }
      if(location.getX() - 2 > -1 && location.getY() + 1 < 8){
          if(game.pieceAt(location.getX() - 2, location.getY() + 1) == null){
              possibleLocations.add(new IntPair(location.getX() - 2, location.getY() + 1));
          }
          else{
              if(!game.pieceAt(location.getX() - 2, location.getY() + 1).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX() - 2, location.getY() + 1));
              }
          }
      }
      if(location.getX() - 1 > -1 && location.getY() + 2 < 8){
          if(game.pieceAt(location.getX() - 1, location.getY() + 2) == null){
            possibleLocations.add(new IntPair(location.getX() - 1, location.getY() + 2));
          }
          else{
              if(!game.pieceAt(location.getX() - 1, location.getY() + 2).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX() - 1, location.getY() + 2));
              }
      }
      }
      if(location.getX() + 1 < 8 && location.getY() + 2 < 8){
          if(game.pieceAt(location.getX() + 1, location.getY() + 2) == null){
              possibleLocations.add(new IntPair(location.getX() + 1, location.getY() + 2));
          }
          else{
              if(!game.pieceAt(location.getX() + 1, location.getY() + 2).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX() + 1, location.getY() + 2));
              }
          }
      }
      if(location.getX() + 2 < 8 && location.getY() + 1 < 8){
          if(game.pieceAt(location.getX() + 2, location.getY() + 1) == null){
              possibleLocations.add(new IntPair(location.getX() + 2, location.getY() + 1));
          }
          else{
              if(!game.pieceAt(location.getX() + 2, location.getY() + 1).getColour().equals(this.getColour())){
                  possibleLocations.add(new IntPair(location.getX() + 2, location.getY() + 1));
              }
          }
      }

      return possibleLocations;
    }

}
