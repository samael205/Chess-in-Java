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
        chessBoard[1][0] = new Pawn("A2", new IntPair(1, 0), "white");
        chessBoard[1][1] = new Pawn("B2", new IntPair(1, 1), "white");
        chessBoard[1][2] = new Pawn("C2", new IntPair(1, 2), "white");
        chessBoard[1][3] = new Pawn("D2", new IntPair(1, 3), "white");
        chessBoard[1][4] = new Pawn("E2", new IntPair(1, 4), "white");
        chessBoard[1][5] = new Pawn("F2", new IntPair(1, 5), "white");
        chessBoard[1][6] = new Pawn("F2", new IntPair(1, 6), "white");
        chessBoard[1][7] = new Pawn("H2", new IntPair(1, 7), "white");

        chessBoard[0][0] = new Rook("A1", new IntPair(0, 0), "white");
        chessBoard[0][1] = new Knight("B1", new IntPair(0, 1), "white");
        chessBoard[0][2] = new Bishop("C1", new IntPair(0, 2), "white");
        chessBoard[0][3] = new King("D1", new IntPair(0, 3), "white");
        chessBoard[0][4] = new Queen("E1", new IntPair(0, 4), "white");
        chessBoard[0][5] = new Bishop("F1", new IntPair(0, 5), "white");
        chessBoard[0][6] = new Knight("F1", new IntPair(0, 6), "white");
        chessBoard[0][7] = new Rook("H1", new IntPair(0, 7), "white");


        //black pieces
        chessBoard[6][0] = new Pawn("A6", new IntPair(6, 0), "black");
        chessBoard[6][1] = new Pawn("B6", new IntPair(6, 1), "black");
        chessBoard[6][2] = new Pawn("C6", new IntPair(6, 2), "black");
        chessBoard[6][3] = new Pawn("D6", new IntPair(6, 3), "black");
        chessBoard[6][4] = new Pawn("E6", new IntPair(6, 4), "black");
        chessBoard[6][5] = new Pawn("F6", new IntPair(6, 5), "black");
        chessBoard[6][6] = new Pawn("G6", new IntPair(6, 6), "black");
        chessBoard[6][7] = new Pawn("H6", new IntPair(6, 7), "black");

        chessBoard[7][0] = new Rook("A7", new IntPair(7, 0), "black");
        chessBoard[7][1] = new Knight("B7", new IntPair(7, 1), "black");
        chessBoard[7][2] = new Bishop("C7", new IntPair(7, 2), "black");
        chessBoard[7][3] = new King("D7", new IntPair(7, 3), "black");
        chessBoard[7][4] = new Queen("E7", new IntPair(7, 4), "black");
        chessBoard[7][5] = new Bishop("F7", new IntPair(7, 5), "black");
        chessBoard[7][6] = new Knight("G7", new IntPair(7, 6), "black");
        chessBoard[7][7] = new Rook("H7", new IntPair(7, 7), "black");


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

}
