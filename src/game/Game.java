package game;

import pieces.*;
import util.IntPair;

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

    // Could have arguments for timed games
    public Game(){


        chessBoard = new GamePiece[8][8];

        blackPlayer = new Player("white");
        whitePlayer = new Player("black");

        currentPlayer = whitePlayer;
        //White pieces
        //Constructor: id, location, colour
        chessBoard[0][1] = new Pawn("A2", new IntPair(0, 1), "black");
        chessBoard[1][1] = new Pawn("B2", new IntPair(1, 1), "black");
        chessBoard[2][1] = new Pawn("C2", new IntPair(2, 1), "black");
        chessBoard[3][1] = new Pawn("D2", new IntPair(3, 1), "black");
        chessBoard[4][1] = new Pawn("E2", new IntPair(4, 1), "black");
        chessBoard[5][1] = new Pawn("F2", new IntPair(5, 1), "black");
        chessBoard[6][1] = new Pawn("F2", new IntPair(6, 1), "black");
        chessBoard[7][1] = new Pawn("H2", new IntPair(7, 1), "black");

        chessBoard[0][0] = new Rook("A1", new IntPair(0, 0), "black");
        chessBoard[1][0] = new Knight("B1", new IntPair(1, 0), "black");
        chessBoard[2][0] = new Bishop("C1", new IntPair(2, 0), "black");
        chessBoard[3][0] = new Queen("D1", new IntPair(3,0),"black");
        chessBoard[4][0] = new King("E1", new IntPair(4, 0), "black");
        chessBoard[5][0] = new Bishop("F1", new IntPair(5, 0), "black");
        chessBoard[6][0] = new Knight("F1", new IntPair(6, 0), "black");
        chessBoard[7][0] = new Rook("H1", new IntPair(7, 0), "black");


        //black pieces
        chessBoard[0][6] = new Pawn("A6", new IntPair(0, 6), "white");
        chessBoard[1][6] = new Pawn("B6", new IntPair(1, 6), "white");
        chessBoard[2][6] = new Pawn("C6", new IntPair(2, 6), "white");
        chessBoard[3][6] = new Pawn("D6", new IntPair(3, 6), "white");
        chessBoard[4][6] = new Pawn("E6", new IntPair(4, 6), "white");
        chessBoard[5][6] = new Pawn("F6", new IntPair(5, 6), "white");
        chessBoard[6][6] = new Pawn("G6", new IntPair(6, 6), "white");
        chessBoard[7][6] = new Pawn("H6", new IntPair(7, 6), "white");

        chessBoard[0][7] = new Rook("A7", new IntPair(0, 7), "white");
        chessBoard[1][7] = new Knight("B7", new IntPair(1, 7), "white");
        chessBoard[2][7] = new Bishop("C7", new IntPair(2, 7), "white");
        chessBoard[3][7] = new Queen("D7", new IntPair(3,7), "white");
        chessBoard[4][7] = new King("E7", new IntPair(4, 7), "white");
        chessBoard[5][7] = new Bishop("F7", new IntPair(5, 7), "white");
        chessBoard[6][7] = new Knight("G7", new IntPair(6, 7), "white");
        chessBoard[7][7] = new Rook("H7", new IntPair(7, 7), "white");


    }

    //An enum would make this process much simpler
    public void changeTurn() {
        if (currentPlayer.getColour().equals("white")){
            currentPlayer = blackPlayer;
        }
        else{
            currentPlayer = whitePlayer;
        }
    }

    public GamePiece pieceAt(int x, int y){
        // Returns the piece at (x,y), and if there is no piece there, return null.
        return chessBoard[x][y];
    }
    public void setPieceAt(int x, int y, GamePiece piece){
        chessBoard[x][y] = piece;
    }

}
