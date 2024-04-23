public class Rook extends Piece {

    public Rook(boolean isW, int r, int c){
        super(isW, r, c, Piece.ROOK);
        super.pointValue = 5;
    }

    public boolean canMoveTo(Board gameBoard, String to){
        Piece[][] board = gameBoard.getChessBoard();
        int toC = Board.translations.get(to.substring(0 ,1));
        int toR = 8 - Integer.parseInt(to.substring(1, 2));
        if (toR == super.row) {
            if (toC < super.col) {
                for (int i = super.col - 1; i > toC; i--) {
                    if (board[super.row][i] != null) {
                        return false;
                    }
                }
                if(board[toR][toC] == null ||board[toR][toC].getColor() != this.isWhite) {
                    return true;
                }
            }
            if (toC > super.col) {
                for (int i = super.col + 1; i < toC; i++) {
                    if (board[super.row][i] != null) {
                        return false;
                    }
                }
                if(board[toR][toC] == null ||board[toR][toC].getColor() != this.isWhite) {
                    return true;
                }
            }
        }
        if (toC == super.col) {
            if (toR < super.row) {
                for (int i = super.row - 1; i > toR; i--) {
                    if (board[i][super.col] != null) {
                        return false;
                    }
                }
                if(board[toR][toC] == null ||board[toR][toC].getColor() != this.isWhite) {
                    return true;
                }
            }
            if (toR > super.row) {
                for (int i = super.row + 1; i < toR; i++) {
                    if (board[i][super.col] != null) {
                        return false;
                    }
                }
                if(board[toR][toC] == null ||board[toR][toC].getColor() != this.isWhite) {
                    return true;
                }
            }
        }
        return false;
    }

    // public String toString(){
    //     String reset = "\u001B[0m";
    // 	String black = "\u001B[30m";
    // 	String rook = "\u2656";
    // 	String rookB = black + "\u265C";
    //     if (this.isWhite){
    //         return " " + rook + " ";
    //     } else {
    //         return " " + rookB + " " + reset;
    //     }
    // }
}