package pieces;

import game.Game;
import util.IntPair;

import java.awt.geom.Point2D;
import java.util.ArrayList;


public abstract class GamePiece {

    protected boolean hasMoved;
    protected boolean isThreatening;
    protected boolean taken;
    protected String colour;
    protected IntPair location;
    protected Game game;
    protected String id;

    public String getColour(){ return colour; }

    public void setLocation(IntPair loc){location = loc;}

    public void clearCurrentSpace(){
        game.chessBoard[location.getX()][location.getY()] = null;
    }
    public void take(){
        location = null;
        taken = true;
        clearCurrentSpace();
    }

    public void moveTo(IntPair target){
        ArrayList<intPair> possibleLocations = this.canMoveTo();
        for(IntPair loc : possibleLocations){
            if(target == loc){
                //Check if there is an enemy piece there.
                // canMoveTo will eliminate possible friendly pieces and game borders.
                if (game.chessBoard[target.getX()][target.getY()] != null){
                    game.chessBoard[target.getX()][target.getY()].take();
                }
                //empty the current position
                clearCurrentSpace();
                //update the piece's location to the target
                this.setLocation(target);
                //update chessboard with this piece at current location
                game.chessBoard[target.getX()][target.getY()] = this;
                hasMoved = true;
            }
        }
    }

    public abstract ArrayList<intPair> canMoveTo();
}
