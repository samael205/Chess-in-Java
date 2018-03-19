package game;

import javafx.event.Event;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import pieces.*;
import util.IntPair;
import java.util.ArrayList;

import static javafx.application.Platform.exit;


public class ChessView extends GridPane{

    private GridPane board;
    private Button[][] tiles;
    private Game game;
    private GamePiece selectedPiece;
    private boolean pieceSelected;

    public Button[][] getTiles() { return tiles; }
    public Game getGame(){ return game; }

    public ChessView(Game g){
        board = new GridPane();
        board.setId("chessBoard");
        tiles = new Button[8][8];

        game = g;

        boolean temp = true;
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                tiles[column][row] = new Button();
                tiles[column][row].setPrefSize(80, 80);
                /*
                Creating the checkerboard pattern for the tiles by adding CSS ids.
                This is so the tiles can easily be controlled by the stylesheet.
                See 'App.java' for info on CSS styling.
                */
                if(temp){
                    tiles[column][row].setId("lightTile");
                }else{
                    tiles[column][row].setId("darkTile");
                }
                temp = !temp;

                tiles[column][row].setOnMousePressed(e -> handleMousePress(e));

                // Adding the tile to the board
                board.add(tiles[column][row], column, row);
            }
            temp = !temp;
        }
        add(board, 0, 0);
    }

    public void update(){
        if(selectedPiece != null){
            ArrayList<IntPair> possibleLocations = new ArrayList<>(selectedPiece.canMoveTo());

            if(game.getCurrentPlayer().isInCheckmate()){
                System.out.println(game.getCurrentPlayer() + " is the winner!");
                exit();
            }

            if(game.getCurrentPlayer().isInCheck()) {
                System.out.println(game.getCurrentPlayer() + " is in check. They must respond.");
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

        int c = 0;
        int r = 0;
        OUTER:
        for (r = 0; r < 8; r++) {
            for (c = 0; c < 8; c++) {
                if (e.getSource() == tiles[c][r]) {
                    break OUTER;
                }
            }
        }

        if(pieceSelected){

            if(game.pieceAt(c, r) != null){
                if(game.pieceAt(c, r).getColour().equals(game.getCurrentPlayer().getColour())){
                    clearSelection();
                    return;
                }
            }
            if(selectedPiece.moveTo(new IntPair(c, r))){
                game.changeTurn();
                GamePiece king = null;
                Player player = game.getCurrentPlayer();
                OUTER:
                for (r = 0; r < 8; r++) {
                    for (c = 0; c < 8; c++) {
                        if (game.pieceAt(c, r) instanceof King && game.pieceAt(c, r).getColour().equals(player.getColour())) {
                            king = game.pieceAt(c, r);
                            break OUTER;
                        }
                    }
                }
                checkForCheck(king);
            }
            clearSelection();
        }
        else {
            //if the tile has a piece
            if (game.pieceAt(c, r) != null) {
                //if that piece belongs to them
                if (game.pieceAt(c, r).getColour().equals(game.getCurrentPlayer().getColour())) {
                    if(game.pieceAt(c, r) instanceof King){
                        GamePiece king = game.pieceAt(c, r);
                        checkForCheck(king);
                    }
                    selectedPiece = game.pieceAt(c, r);
                    pieceSelected = true;
                    highlightMoves();

                }
            }
        }
     update();

    }

    private void checkForCheck(GamePiece king){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(game.pieceAt(i, j) != null){
                    for(IntPair loc: game.pieceAt(i, j).canMoveTo()){
                        if(game.pieceAt(loc.getX(), loc.getY()) == king){
                            game.getCurrentPlayer().setCheck(true);
                            return;
                        }
                    }
                }
            }
        }
    }
    private void clearSelection() {
        pieceSelected = false;
        selectedPiece = null;
        clearHighlights();
        update();
    }

    private void highlightMoves() {
        ArrayList<IntPair> possibleLocations = new ArrayList<>(selectedPiece.canMoveTo());

        for(IntPair loc : possibleLocations){
            tiles[loc.getX()][loc.getY()].setStyle("-fx-border-color: blue;");

        }
    }

    private void clearHighlights(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++) {
                tiles[x][y].setStyle("-fx-border-color: none;");
            }

        }
    }

    private void setImage(int x, int y, String path){
        // Sets the current background image of the passed tile to the one at the passed path, and re-sizes it
        //tiles[x][y].getStyle() +
        tiles[x][y].setStyle("-fx-background-image: url(" + path + ") no-repeat;"
                + "-fx-background-size: " + (int)tiles[x][y].getWidth() + ", " + (int)tiles[x][y].getHeight());
    }
}
