import java.util.HashMap;
public class Board {
    private HashMap<String, Integer> translate;
    private Piece[][] chessBoard;
    private boolean whiteTurn;
    public Board(){
        this.translate = new HashMap<String, Integer>();
        this.translate.put("a", 0);
        this.translate.put("b", 1);
        this.translate.put("c", 2);
        this.translate.put("d", 3);
        this.translate.put("e", 4);
        this.translate.put("f", 5);
        this.translate.put("g", 6);
        this.translate.put("h", 7);
        this.whiteTurn = true;
        this.chessBoard = new Piece[8][8];
    }

    public void setup(){
        for (int i = 0; i < 8; i++){
            this.chessBoard[1][i] = new Pawn(false, 0, i);
            this.chessBoard[6][i] = new Pawn(true, 0, i);
        }

        for (int i = 0; i < 8; i++){
            if (i == 0 || i == 7){
                this.chessBoard[0][i] = new Rook(false, 1, i);
                this.chessBoard[7][i] = new Rook(true, 6, i);
            } else if (i == 1 || i == 6){
                this.chessBoard[0][i] = new Knight(false, 1, i);
                this.chessBoard[7][i] = new Knight(true, 6, i);
            } else if (i == 2 || i == 5){
                this.chessBoard[0][i] = new Bishop(false, 1, i);
                this.chessBoard[7][i] = new Bishop(true, 6, i);
            } else if (i == 3){
                this.chessBoard[0][i] = new Queen(false, 1, i);
                this.chessBoard[7][i] = new Queen(true, 6, i);
            } else {
                this.chessBoard[0][i] = new King(false, 1, i);
                this.chessBoard[7][i] = new King(true, 6, i);
            }
        }
    }

    public void takeTurn(String from, String to){
        int fromC = this.translate.get(from.substring(0, 1));
        int fromR = 8 - Integer.parseInt(from.substring(1, 2));
        Piece fromP = this.chessBoard[fromR][fromC];

        int toC = this.translate.get(to.substring(0 ,1));
        int toR = 8 - Integer.parseInt(to.substring(1, 2));
        Piece toP = this.chessBoard[toR][toC];

        this.chessBoard[fromR][fromC] = null;
        fromP.setCoord(toR, toC);
        this.chessBoard[toR][toC] = fromP;
    }

    public boolean piecePresent(String from){
        int fromC = this.translate.get(from.substring(0, 1));
        int fromR = 8 - Integer.parseInt(from.substring(1, 2));
        Piece fromP = this.chessBoard[fromR][fromC];
        return (fromP != null);
    }

//    public void print(){
//        for (int r = 0; r < 8; r++){
//            for (int c = 0; c < 8; c++){
//                String pChar = (chessBoard[r][c] == null) ? Piece.PAWN : chessBoard[r][c].toString();
//                if ((r + c) % 2 == 0){
//                    if (this.chessBoard[r][c] != null){
//
//                    }
//                    System.out.print(Colors.GREY_BG + pChar + Colors.GREY_BG + Colors.RESET);
//                } else {
//                    System.out.print(Colors.GREEN_BG + pChar + Colors.GREEN_BG + Colors.RESET);
//                }
//            }
//            System.out.println();
//        }
//    }
//hello there how are u
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
}