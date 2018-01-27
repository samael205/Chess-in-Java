package game;

public class Player {

    private String colour;
    private boolean inCheck;

    //1 is white, 0 is black
    public Player(String c){
        colour = c;
        inCheck = false;
    }

    public String getColour(){ return colour; }
    public boolean isInCheck(){ return inCheck; }
    public void setCheck(boolean check){
      inCheck = check;
    }

}
