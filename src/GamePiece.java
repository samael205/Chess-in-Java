import java.awt.geom.Point2D;

/**
 * Created by admin on 2017-09-17.
 */
public abstract class GamePiece {

    private Point2D location;
    private static String colour;
    private boolean taken;

    public Point2D getLocation(){return location;}
    public String getColour(){return colour;}
    public boolean isTaken(){return taken;}

    public void setLocation(Point2D l){location = l;}

    public GamePiece(String c){
        colour = c;
    }

    public void take(){
        location = null;
        taken = true;
        clearCurrentSpace();
    }
    public void clearCurrentSpace(){
        chessboard[location.getX()][location.getY()] = null;
    }

    //Varies depending on the piece.
    public abstract Point2D[] canMoveTo();

    //Should work for all pieces
    public void moveTo(Point2D target){

        Point2D[] possibleLocations = this.canMoveTo();

        for (int i = 0; i < possibleLocations.length; i++){
            if (target == possibleLocations[i]){
                //Check if there is an enemy piece there.
                // canMoveTo will eliminate possible friendly pieces and game borders.
                if (chessboard[target.getX()][target.getY()] != null){
                    chessboard[target.getX()][target.getY()].take();
                }
                //empty the current position
                clearCurrentSpace();
                //update the piece's location to the target
                this.setLocation(target);
                //update chessboard with this piece at current location
                chessboard[target.getX()][target.getY()] = this;
            }
        }
        //Update the view!
        view.update();
        //change turn
    }
}
