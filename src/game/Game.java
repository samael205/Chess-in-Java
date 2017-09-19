package game;

import pieces.*;

public class Game {
    /*
     Representation of the game, keeps track of:
      -an 8x8 chessboard
      -what pieces are taken
      -the current player
      -what piece is selected
    */

    public GamePiece[][] chessBoard;
    private GamePiece[] takenPieces;
    private Player currentPlayer;
    private Player blackPlayer;
    private Player whitePlayer;
    private GamePiece currentPiece;

    // Could have possible boolean argument for a timed game or not
    public Game(){
        chessBoard = new GamePiece[8][8];
        chessBoard[2][1] = new Pawn();
        blackPlayer = new Player("black");
        whitePlayer = new Player("white");
        currentPlayer = whitePlayer;
    }

    public void changeTurn(){
        if(currentPlayer.getColour().equals("white")){
            currentPlayer = blackPlayer;
        }else{
            currentPlayer = whitePlayer;
        }
    }

    public GamePiece pieceAt(int x, int y){
        // Returns the piece at (x,y), and if there is no piece there, return null.
        return chessBoard[x][y];
    }

}
