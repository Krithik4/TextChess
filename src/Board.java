public class Board {
    private Piece[][] chessBoard;

    public Board(){
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
                    //change the color black to match the green square
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