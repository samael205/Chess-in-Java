package src.app;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.*;
//import javafx.scene.layout.Button;
import pieces.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.ThreadLocalRandom;

public class ChessView extends GridPane{
    /*
    This is the main class for the view of the game.
    Currently on has one Node element, 'board', but will have more elements such as:
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
    private HBox buttonHBox;

    public Button[][] getTiles() { return tiles; }
    public Game getGame(){ return game; }

    public ChessView(Game g){
        board = new GridPane();
        //board.setId("chessBoard");
        board.setPrefSize(1200, 1200);
        board.setMinSize(600, 600);
        setPadding(new Insets(10, 10, 10, 10));
        setHgap(20);
        setVgap(20);
        
        
        for (int j = 0; j < 8; j++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100);
            cc.setHgrow(Priority.ALWAYS);
            board.getColumnConstraints().add(cc);
        }

        for (int j = 0; j < 8; j++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100);
            rc.setVgrow(Priority.ALWAYS);
            board.getRowConstraints().add(rc);
        }
        
        
        
        //Chess is an 8 x 8 board. Eventually we should have axes labeled A-G, 1-8
        tiles = new Button[8][8];
        game = g;
        
        buttonHBox = new HBox();


        //Concede button. This is not the same as agreeing to a draw.
        Button concedeButton = new Button("Concede");
        //temporary location for testing
        concedeButton.setPrefSize(200, 75);
        
        buttonHBox.relocate(0, 850);
        buttonHBox.getChildren().add(concedeButton);
        
        
        boolean white = false;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
            	Button b = new Button();
            	b.setMaxSize(200,  200);
            	b.setMinSize(50,  50);
                
                /*
                Creating the checkerboard pattern for the tiles by adding CSS ids.
                This is so the tiles can easily be controlled by the stylesheet.
                See 'App.java' for info on CSS styling.
                */

            	b.setShape(new Rectangle(100, 100));
                if(white){
                	b.setOpacity(100);
                	//white
                	b.setStyle("-fx-base: rgb(255,255,255);");
                    //tiles[r][c].setId("lightTile");
                }else{
                	b.setOpacity(100);
                	//black
                	b.setStyle("-fx-base: rgb(0,0,0);");
                   // tiles[r][c].setId("darkTile");
                }
                white = !white;

                b.setOnMousePressed(e -> handleMousePress(e));
                tiles[r][c]= b;

                /*
                Adding the event handler to each button using a lambda expression, equivalent to:

                tiles[r][c].setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        handleMousePress(event);
                    }
                });
                */

                // Adding the tile to the board
                board.add(tiles[r][c], r, c);
            }
            white = !white;
        }
        
        add(board, 0, 0);
        add(buttonHBox, 0, 1);
        //getChildren().addAll(board, buttonHBox);
        //add(concedeButton);
        update();
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
        int r, c=-1;
        OUTER:
        for(r=0; r<8; r++){
            for(c=0; c<8; c++){
                if(e.getSource() == tiles[r][c])
                    break OUTER;
            }
        }
        Button pressedTile = tiles[r][c];

        // Test code. Sets the clicked tile to a random piece
        /*
        final String[] pieceType = {"_bishop.png", "_king.png", "_knight.png", "_pawn.png", "_queen.png", "_rook.png"};
        String path = "/resources/images/";
        if(ThreadLocalRandom.current().nextBoolean()) path += "white";
        else path += "black";
        int index = ThreadLocalRandom.current().nextInt(6);
        setImage(r, c,path + pieceType[index]);
        */
    }

    private void setImage(int x, int y, String path){
        // Sets the current background image of the passed tile to the one at the passed path, and re-sizes it
        tiles[x][y].setStyle("-fx-background-image: url(" + path + ");"
                + "-fx-background-size: " + (int)tiles[x][y].getWidth() + ", " + (int)tiles[x][y].getHeight());
    }
}
