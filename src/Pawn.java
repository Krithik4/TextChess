import java.util.HashSet;

public class Pawn extends Piece {
    boolean onHomeRow;
    public Pawn(boolean isW, int r, int c){
        super(isW, r, c, Piece.PAWN);
        this.onHomeRow = true;
        super.pointValue = 1;
    }

    // public String toString(){
    //     String reset = "\u001B[0m";
    // 	String black = "\u001B[30m";
    // 	String pawn = "\u2659";
    // 	String pawnB = black + "\u265F";
    //     if (this.isWhite){
    //         return " " + pawn + " ";
    //     } else {
    //         return " " + pawnB + " " + reset;
    //     }
    // }

    public boolean canMoveTo(Board gameBoard, String to){
        HashSet<String> possibleMoves = new HashSet<String>();
        Piece[][] board = gameBoard.getChessBoard();
        int forward = this.isWhite ? -1 : 1;
        if (onHomeRow) { //start of vert moves
            if (board[this.row + forward][this.col] == null) {
                possibleMoves.add(Board.revTranslations.get(this.col) + String.valueOf(8 - (this.row + forward)));
                if (board[this.row + 2 * forward][this.col] == null) {
                    possibleMoves.add(Board.revTranslations.get(this.col) + String.valueOf(8 - (this.row + 2 * forward)));
                }
            }
        } else {
            if (board[this.row + forward][this.col] == null) {
                possibleMoves.add(Board.revTranslations.get(this.col) + String.valueOf(8 - (this.row + forward)));
            }
        }
        int left = this.col - 1; //start of capture stuff
        int right = this.col + 1;
        if (this.col == 7) {
            if (board[this.row + forward][left] != null && board[this.row + forward][left].getColor() != this.isWhite) {
                possibleMoves.add(Board.revTranslations.get(left) + String.valueOf(8 - (this.row + forward)));
            }
        } else if (this.col == 0) {
            if (board[this.row + forward][right] != null && board[this.row + forward][right].getColor() != this.isWhite) {
                possibleMoves.add(Board.revTranslations.get(right) + String.valueOf(8 - (this.row + forward)));
            }
        } else {
            if (board[this.row + forward][left] != null && board[this.row + forward][left].getColor() != this.isWhite) {
                possibleMoves.add(Board.revTranslations.get(left) + String.valueOf(8 - (this.row + forward)));
            }
            if (board[this.row + forward][right] != null && board[this.row + forward][right].getColor() != this.isWhite) {
                possibleMoves.add(Board.revTranslations.get(right) + String.valueOf(8 - (this.row + forward)));
            }
        }
        if (possibleMoves.contains(to) && this.onHomeRow){
            this.onHomeRow = !this.onHomeRow;
        }
        return possibleMoves.contains(to);
    }
}