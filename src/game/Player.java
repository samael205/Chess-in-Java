package game;

public class Player {
    private String colour;
    private boolean inCheck;

    public Player(String c){
        colour = c;
        inCheck = false;
    }
    public String getColour(){ return colour; }
    public boolean isInCheck(){ return inCheck; }
}
