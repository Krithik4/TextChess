import java.util.HashMap;
import java.util.Scanner;

public class Board {
    public static HashMap<String, Integer> translations;
    public static HashMap<Integer, String> revTranslations;
    private Piece[][] chessBoard;
    private boolean isWhiteTurn;
    public Board(){
        Board.translations = new HashMap<String, Integer>();
        Board.translations.put("a", 0);
        Board.translations.put("b", 1);
        Board.translations.put("c", 2);
        Board.translations.put("d", 3);
        Board.translations.put("e", 4);
        Board.translations.put("f", 5);
        Board.translations.put("g", 6);
        Board.translations.put("h", 7);

        Board.revTranslations = new HashMap<Integer, String>();
        Board.revTranslations.put(0, "a");
        Board.revTranslations.put(1, "b");
        Board.revTranslations.put(2, "c");
        Board.revTranslations.put(3, "d");
        Board.revTranslations.put(4, "e");
        Board.revTranslations.put(5, "f");
        Board.revTranslations.put(6, "g");
        Board.revTranslations.put(7, "h");
        this.isWhiteTurn = true;
        this.chessBoard = new Piece[8][8];
    }

    public void setup(){
        for (int i = 0; i < 8; i++){
            this.chessBoard[1][i] = new Pawn(false, 1, i);
            this.chessBoard[6][i] = new Pawn(true, 6, i);
        }

        for (int i = 0; i < 8; i++){
            if (i == 0 || i == 7){
                this.chessBoard[0][i] = new Rook(false, 0, i);
                this.chessBoard[7][i] = new Rook(true, 7, i);
            } else if (i == 1 || i == 6){
                this.chessBoard[0][i] = new Knight(false, 0, i);
                this.chessBoard[7][i] = new Knight(true, 7, i);
            } else if (i == 2 || i == 5){
                this.chessBoard[0][i] = new Bishop(false, 0, i);
                this.chessBoard[7][i] = new Bishop(true, 7, i);
            } else if (i == 3){
                this.chessBoard[0][i] = new Queen(false, 0, i);
                this.chessBoard[7][i] = new Queen(true, 7, i);
            } else {
                this.chessBoard[0][i] = new King(false, 0, i);
                this.chessBoard[7][i] = new King(true, 7, i);
            }
        }
    }

//    public void takeTurn(String from, String to){
//        int fromC = this.translate.get(from.substring(0, 1));
//        int fromR = 8 - Integer.parseInt(from.substring(1, 2));
//        Piece fromP = this.chessBoard[fromR][fromC];
//
//        int toC = this.translate.get(to.substring(0 ,1));
//        int toR = 8 - Integer.parseInt(to.substring(1, 2));
//        Piece toP = this.chessBoard[toR][toC];
//
//        this.chessBoard[fromR][fromC] = null;
//        fromP.setCoord(toR, toC);
//        this.chessBoard[toR][toC] = fromP;
//    }

    public void takeTurn(String from, String to){
        if (validFromPiece(from)){
            int fromC = Board.translations.get(from.substring(0, 1));
            int fromR = 8 - Integer.parseInt(from.substring(1, 2));
            Piece fromP = this.chessBoard[fromR][fromC];

            if (fromP.canMoveTo(this, to)){ //fromP.canMoveTo(this.chessBoard, to);
                int toC = Board.translations.get(to.substring(0 ,1));
                int toR = 8 - Integer.parseInt(to.substring(1, 2));
                this.chessBoard[fromR][fromC] = null;
                fromP.setCoord(toR, toC);
                this.chessBoard[toR][toC] = fromP;
                if (fromP instanceof Pawn){
                    if (fromP.getColor()){
                        if (toR == 0){
                            System.out.print("Type the first letter of the piece you want (k, b, r, q): ");
                            Scanner input = new Scanner(System.in);
                            String piece = input.nextLine();
                            promotePiece(fromP.getColor(), toR, toC, piece);
                        }
                    } else {
                        if (toR == 7){
                            System.out.print("Type the first letter of the piece you want (k, b, r, q): ");
                            Scanner input = new Scanner(System.in);
                            String piece = input.nextLine();
                            promotePiece(fromP.getColor(), toR, toC, piece);
                        }
                    }
                }
                this.isWhiteTurn = !this.isWhiteTurn;
            } else {
                System.out.println("Not a valid move");
            }
        } else {
            System.out.println("Choose a valid piece to move that is your color");
        }
    }

    public boolean getTurn(){
        return this.isWhiteTurn;
    }

    public void promotePiece(boolean color, int row, int col, String p){
        switch (p){
            case "k":
                this.chessBoard[row][col] = new Knight(color, row, col);
                break;
            case "b":
                this.chessBoard[row][col] = new Bishop(color, row, col);
                break;
            case "r":
                this.chessBoard[row][col] = new Rook(color, row, col);
                break;
            case "q":
                this.chessBoard[row][col] = new Queen(color, row, col);
                break;
        }
    }

    public boolean validFromPiece(String from){
        int fromC = Board.translations.get(from.substring(0, 1));
        int fromR = 8 - Integer.parseInt(from.substring(1, 2));
        Piece fromP = this.chessBoard[fromR][fromC];
        if (fromP == null){
            return false;
        }
        if (fromP.getColor() == this.isWhiteTurn){
            return true;
        }
        return false;
    }

    public boolean piecePresent(String from){
        int fromC = Board.translations.get(from.substring(0, 1));
        int fromR = 8 - Integer.parseInt(from.substring(1, 2));
        Piece fromP = this.chessBoard[fromR][fromC];
        return (fromP != null);
    }

    public String toString() {
        String boardToPrint = "";
        for (int r = 0; r < 8; r++) {
            boardToPrint += (8 - r) + " ";
            for (int c = 0; c < 8; c++) {
                String sqColor = ((r + c) % 2 == 0) ? Colors.GREY_BG : Colors.GREEN_BG;
                String pieceStr = (this.chessBoard[r][c] != null) ? this.chessBoard[r][c].toString() : "   ";
                if (pieceStr.equals("   ")){
                    String fillerTxtColor = (sqColor.equals(Colors.GREY_BG)) ? Colors.WHITE : Colors.GREEN;
                    //change the color block to match the green square
                    boardToPrint += sqColor + " " + fillerTxtColor + Piece.PAWN + " " + Colors.RESET;
                } else {
                    boardToPrint += sqColor + pieceStr + sqColor + Colors.RESET;
                }
            }
            boardToPrint += "\n";
        }
        return boardToPrint + "   a   b   c  d   e  f   g   h"/* col letters*/;
    }

    public Piece[][] getChessBoard() {
        return this.chessBoard;
    }
}