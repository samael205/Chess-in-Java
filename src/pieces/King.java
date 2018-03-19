package pieces;

import game.Game;
import util.IntPair;

import java.util.ArrayList;

public class King extends GamePiece{

    public King(String idString, IntPair loc, String c, Game g){
        super(idString, loc, c, g);
    }

    public ArrayList<IntPair> canMoveTo(){

        ArrayList<IntPair> possibleLocations = new ArrayList<>();


        if(location.getY() + 1 < 8) {
            if (game.pieceAt(location.getX(), location.getY() + 1) != null) {
                if(!game.pieceAt(location.getX(), location.getY() + 1).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX(), location.getY() + 1));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX(), location.getY() + 1));
            }
        }
        if(location.getY() - 1 >= 0) {
            if (game.pieceAt(location.getX(), location.getY() - 1) != null) {
                if(!game.pieceAt(location.getX(), location.getY() - 1).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX(), location.getY() - 1));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX(), location.getY() - 1));
            }
        }
        if(location.getX() + 1 < 8) {
            if (game.pieceAt(location.getX() + 1, location.getY()) != null) {
                if(!game.pieceAt(location.getX() + 1, location.getY()).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX() + 1, location.getY()));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX() + 1, location.getY()));
            }
        }

        if(location.getX() - 1 >= 0) {
            if (game.pieceAt(location.getX() - 1, location.getY()) != null) {
                if(!game.pieceAt(location.getX() - 1, location.getY()).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX() - 1, location.getY()));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX() - 1, location.getY()));
            }
        }

        if(location.getX() + 1 < 8 && location.getY() - 1 >=0 ) {
            if (game.pieceAt(location.getX() + 1, location.getY() - 1) != null) {
                if(!game.pieceAt(location.getX() + 1, location.getY() - 1).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX() + 1, location.getY() - 1));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX() + 1, location.getY() - 1));
            }
        }
        if(location.getX() - 1 >= 0 && location.getY() - 1 >=0 ) {
            if (game.pieceAt(location.getX() - 1, location.getY() - 1) != null) {
                if(!game.pieceAt(location.getX() - 1, location.getY() - 1).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX() - 1, location.getY() - 1));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX() - 1, location.getY() - 1));
            }
        }

        if(location.getX() - 1 >= 0 && location.getY() + 1 < 8 ) {
            if (game.pieceAt(location.getX() - 1, location.getY() + 1) != null) {
                if(!game.pieceAt(location.getX() - 1, location.getY() + 1).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX() - 1, location.getY() + 1));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX() - 1, location.getY() + 1));
            }
        }

        if(location.getX() + 1 < 8 && location.getY() + 1 < 8 ) {
            if (game.pieceAt(location.getX() + 1, location.getY() + 1) != null) {
                if(!game.pieceAt(location.getX() + 1, location.getY() + 1).colour.equals(this.colour)){
                    possibleLocations.add(new IntPair(location.getX() + 1, location.getY() + 1));
                }
            } else {
                possibleLocations.add(new IntPair(location.getX() + 1, location.getY() + 1));
            }
        }

        return possibleLocations;

    }
}
