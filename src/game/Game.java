package game;

import pieces.GamePiece;

public class Game {
    /*
     Representation of the game, keeps track of:
      -an 8x8 chessboard
      -what pieces are taken
      -the current player
      -what piece is selected
    */

    private GamePiece[][] chessBoard;
    private GamePiece[] takenPieces;
    private GamePiece currentPiece;
    private String currentPlayer;
    

    // Could have possible boolean argument for a timed game or not
    
    public Game(){
        chessBoard = new GamePiece[8][8];
        currentPlayer = "white";
    }
    
    // We might want to consider having the current player be a class, it would be able to store it's opposite and it's colour. 
    // It might look neater that way, and might make initialization a bit cleaner.
    
    public void changeTurn(){
        if(currentPlayer.equals("white")){
            currentPlayer = "black";
        }else{
            currentPlayer = "white";
        }
    }

    public GamePiece pieceAt(int x, int y){
        // Returns the piece at (x,y), and if there is no piece there, return null.
        return chessBoard[x][y];
    }

    public void setSelectedPiece(int x, int y){
        /*
         Sets the current selected piece to the one at (x,y), if it's an empty space, do nothing,
         if it's the same piece, deselect it
        */
        if(chessBoard[x][y] == currentPiece){
            currentPiece = null;
        }else if(chessBoard[x][y] != null){
            currentPiece = chessBoard[x][y];
        }
    }

    public boolean moveTo(int x, int y){
        // Tries to move the current piece to (x,y), returns true if it does, and false if it does not
        return false;
    }
}
