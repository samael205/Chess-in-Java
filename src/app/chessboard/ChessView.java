package app.chessboard;

import game.Game;
import javafx.event.Event;
import javafx.scene.layout.*;
import pieces.*;
import util.IntPair;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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

    I chose to use the Region class over the Button class because Regions have no built-in styling,
    while Buttons have a lot. This will allows us to get the tiles to look exactly how we want.
     */
    private GridPane board;
    private Region[][] tiles;
    private Game game;

    public Region[][] getTiles() { return tiles; }
    public Game getGame(){ return game; }

    public ChessView(Game g){
        board = new GridPane();
        board.setId("chessBoard");
        tiles = new Region[8][8];

        game = g;

        boolean temp = true;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                tiles[r][c] = new Region();
                /*
                Creating the checkerboard pattern for the tiles by adding CSS ids.
                This is so the tiles can easily be controlled by the stylesheet.
                See 'App.java' for info on CSS styling.
                */
                if(temp){
                    tiles[r][c].setId("lightTile");
                }else{
                    tiles[r][c].setId("darkTile");
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
                tiles[r][c].setOnMousePressed(e -> handleMousePress(e));

                // Adding the tile to the board
                board.add(tiles[r][c], r, c);
            }
            temp = !temp;
        }
        add(board, 0, 0);
    }

    public void update(){
        for(int r = 0; r < 8; r++){
            for(int c = 0; c < 8; c++){
                GamePiece piece = game.pieceAt(r,c);
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
                    setImage(r, c, "/resources/images/" + piece.getColour() + type);
                }
            }
        }
    }

    private void handleMousePress(Event e){
        /*
        Event handler for every tile. Starts by getting which tile is pressed,
        which we will use later to handle movement of pieces.
         */
        int r, c = 0;
        OUTER:
        for(r = 0; r < 8; r++){
            for(c = 0; c < 8; c++){
                if(e.getSource() == tiles[r][c])
                    break OUTER;
            }
        }
        Region pressedTile = tiles[r][c];
        //if the tile has a piece
        if(game.pieceAt(r, c) != null){
            //if that piece belongs to them
            if(game.pieceAt(r, c).getColour().equals(game.getCurrentPlayer().getColour())){
                ArrayList<IntPair> possibleLocations = new ArrayList<>(game.pieceAt(r, c).canMoveTo());
                /*
                for(IntPair loc : possibleLocations){
                    tiles[loc.getX()][loc.getY()].setId("redTile");
                }
                */
                tiles[r][c].setStyle("-fx-text-fill: red");
            }
        }
        update();
        

    }

    private void setImage(int x, int y, String path){
        // Sets the current background image of the passed tile to the one at the passed path, and re-sizes it
        tiles[x][y].setStyle("-fx-background-image: url(" + path + ");"
                + "-fx-background-size: " + (int)tiles[x][y].getWidth() + ", " + (int)tiles[x][y].getHeight());
    }
}
