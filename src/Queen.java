import java.util.HashSet;

public class Queen extends Piece {

    public Queen(boolean isW, int r, int c){
        super(isW, r, c, Piece.QUEEN);
        super.pointValue = 9;
    }

    public boolean canMoveTo(Board gameBoard, String to) {
        Piece[][] board = gameBoard.getChessBoard();
        int toC = Board.translations.get(to.substring(0 ,1));
        int toR = 8 - Integer.parseInt(to.substring(1, 2));
        HashSet<String> possibleMoves = new HashSet<String>();
        int tempRow = this.row;
        int tempCol = this.col;

        //rook
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

        //bishop
        if (toC > this.col && toR > this.row){
            while (tempRow < 7 && tempCol < 7){
                Piece p = board[++tempRow][++tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempCol = tempRow = 8;
                } else if (p.getColor() == this.isWhite){
                    tempCol = tempRow = 8;
                }
            }
        }
        if (toC < this.col && toR > this.row){
            while (tempRow < 7 && tempCol > 0){
                Piece p = board[++tempRow][--tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempRow = 8;
                    tempCol = -1;
                } else if (p.getColor() == this.isWhite){
                    tempRow = 8;
                    tempCol = -1;
                }
            }
        }
        if (toC > this.col && toR < this.row){
            while (tempRow > 0 && tempCol < 7){
                Piece p = board[--tempRow][++tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempCol = 8;
                    tempRow = -1;
                } else if (p.getColor() == this.isWhite){
                    tempCol = 8;
                    tempRow = -1;
                }
            }
        }
        if (toC < this.col && toR < this.row){
            while (tempRow > 0 && tempCol > 0){
                Piece p = board[--tempRow][--tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempCol = tempRow = -1;
                } else if (p.getColor() == this.isWhite){
                    tempCol = tempRow = -1;
                }
            }
        }
        return possibleMoves.contains(to);
    }

    // public String toString(){
    //     String reset = "\u001B[0m";
    // 	String black = "\u001B[30m";
    // 	String queen = "\u2655";
    // 	String queenB = black + "\u265B";
    //     if (this.isWhite){
    //         return " " + queen + " ";
    //     } else {
    //         return " " + queenB + " " + reset;
    //     }
    // }
}