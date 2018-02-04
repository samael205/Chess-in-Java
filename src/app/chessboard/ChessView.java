package app.chessboard;

import game.Game;
import javafx.event.Event;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import pieces.*;
import util.IntPair;
import java.util.ArrayList;


public class ChessView extends GridPane{
    /*
    This is the main class for the view of the game.
    Currently only has one Node element, 'board', but will have more elements such as:
     -current player
     -buttons for game options
     -turn counter(maybe)
     -each players time(maybe)
     -taken piece list(maybe)

    'board' holds the tiles in a GridPane. Treating the board as one element will help for formatting
    when we add more elements to the view.

    I chose to use the Button class over the Button class because Buttons have no built-in styling,
    while Buttons have a lot. This will allows us to get the tiles to look exactly how we want.
     */
    private GridPane board;
    private Button[][] tiles;
    private Game game;
    private GamePiece selectedPiece;

    public Button[][] getTiles() { return tiles; }
    public Game getGame(){ return game; }

    public ChessView(Game g){
        board = new GridPane();
        board.setId("chessBoard");
        tiles = new Button[8][8];

        game = g;

        boolean temp = true;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                tiles[c][r] = new Button();
                tiles[c][r].setPrefSize(100, 100);
                /*
                Creating the checkerboard pattern for the tiles by adding CSS ids.
                This is so the tiles can easily be controlled by the stylesheet.
                See 'App.java' for info on CSS styling.
                */
                if(temp){
                    tiles[c][r].setId("lightTile");
                }else{
                    tiles[c][r].setId("darkTile");
                }
                temp = !temp;

                /*
                Adding the event handler to each button using a lambda expression, equivalent to:

                tiles[r][c].setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        handleMousePress(event);
                    }
                });
                */
                tiles[c][r].setOnMousePressed(e -> handleMousePress(e));

                // Adding the tile to the board
                board.add(tiles[c][r], c, r);
            }
            temp = !temp;
        }
        add(board, 0, 0);
    }

    public void update(){
        if(selectedPiece != null){
            ArrayList<IntPair> possibleLocations = new ArrayList<>(selectedPiece.canMoveTo());

            for(int r = 0; r < 8; r++){
                for(int c = 0; c < 8; c++){
                    for(int i = 0; i < possibleLocations.size(); i++){
                    if(possibleLocations.get(i).getX() == c && possibleLocations.get(i).getY() == r){
                        //tiles[c][r].setStyle("-fx-background-color: red");
                    }
                    }
                }
            }

        }
        for(int r = 0; r < 8; r++){
            for(int c = 0; c < 8; c++){
                GamePiece piece = game.pieceAt(c,r);
                if(piece != null) {
                    String type = "";
                    if (piece instanceof Bishop)
                        type = "_bishop.png";
                    else if (piece instanceof King)
                        type = "_king.png";
                    else if (piece instanceof Knight)
                        type = "_knight.png";
                    else if (piece instanceof Pawn)
                        type = "_pawn.png";
                    else if (piece instanceof Queen)
                        type = "_queen.png";
                    else if (piece instanceof Rook)
                        type = "_rook.png";

                    setImage(c, r, "/resources/images/" + piece.getColour() + type);

                }
            }
        }
    }

    private void handleMousePress(Event e) {
        /*
        Event handler for every tile. Starts by getting which tile is pressed,
        which we will use later to handle movement of pieces.
         */
        int r, c = 0;
        OUTER:
        for (r = 0; r < 8; r++) {
            for (c = 0; c < 8; c++) {
                if (e.getSource() == tiles[c][r]) {
                    tiles[c][r].setStyle("-fx-border-color: red;");
                    break OUTER;
                }
            }
        }
        Button pressedTile = tiles[c][r];
        //if the tile has a piece
        if (game.pieceAt(c, r) != null) {
            //if that piece belongs to them
            if (game.pieceAt(c, r).getColour().equals(game.getCurrentPlayer().getColour())) {

                selectedPiece = game.pieceAt(c, r);
                ArrayList<IntPair> possibleLocations = new ArrayList<>(selectedPiece.canMoveTo());

                for(IntPair loc : possibleLocations){
                    tiles[loc.getX()][loc.getY()].setStyle("-fx-border-color: blue;");
                    //System.out.println("X");
                    //System.out.println(loc.getX());
                }

            }
         }
     update();

    }

    private void setImage(int x, int y, String path){
        // Sets the current background image of the passed tile to the one at the passed path, and re-sizes it
        //tiles[x][y].getStyle() +
        tiles[x][y].setStyle("-fx-background-image: url(" + path + ");"
                + "-fx-background-size: " + (int)tiles[x][y].getWidth() + ", " + (int)tiles[x][y].getHeight());
    }
}
