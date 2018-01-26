package game;

public class Player {

    private short colour;
    private boolean inCheck;

    //1 is white, 0 is black
    public Player(short c){
        colour = c;
        inCheck = false;
    }

    public short getColour(){ return colour; }
    public boolean isInCheck(){ return inCheck; }
    public void setCheck(boolean check){
      inCheck = check;
    }

}
