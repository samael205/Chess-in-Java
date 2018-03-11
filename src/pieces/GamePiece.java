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

    public GamePiece(String idString, IntPair loc, String c, Game g){
        location = loc;
        id = idString;
        colour = c;
        hasMoved = false;
        isThreatening = false;
        taken = false;
        game = g;
    }

    public String getColour(){ return colour; }

    public void setLocation(IntPair loc){location = loc;}

    public void clearCurrentSpace(){
        game.chessBoard[location.getX()][location.getY()] = null;
    }
    public void pieceIsTaken(){
        location = null;
        taken = true;
        clearCurrentSpace();
    }

    public boolean moveTo(IntPair target){
        ArrayList<IntPair> possibleLocations = this.canMoveTo();
        for(IntPair loc : possibleLocations){
            if(target == loc){
                //Check if there is an enemy piece there.
                // canMoveTo will eliminate possible friendly pieces and game borders.
                if (game.chessBoard[target.getX()][target.getY()] != null){
                    game.chessBoard[target.getX()][target.getY()].pieceIsTaken();
                }
                //empty the current position
                clearCurrentSpace();
                //update the piece's location to the target
                this.setLocation(target);
                //update chessboard with this piece at current location
                game.setPieceAt(target.getX(), target.getY(), this);
                hasMoved = true;
                return true;
            }
        }

        return false;
    }

    public abstract ArrayList<IntPair> canMoveTo();
}
