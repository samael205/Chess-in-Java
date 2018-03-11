package game;

public class Player {

    private String colour;
    private boolean inCheck;
    private boolean hasMovedAPiece;
    private boolean inCheckmate;

    //1 is white, 0 is black
    public Player(String c){
        colour = c;
        inCheck = false;
        hasMovedAPiece = false;
    }

    public boolean hasMovedAPiece() {return hasMovedAPiece;}
    public String getColour(){ return colour; }
    public boolean isInCheck(){ return inCheck; }
    public void setCheck(boolean check){
      inCheck = check;
    }
    public boolean isInCheckmate(){return inCheckmate;}
    public void setInCheckmate(boolean checkmate){inCheckmate = checkmate;}

    public void setHasMovedAPiece(boolean moved){hasMovedAPiece = moved;}

}
