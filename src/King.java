import java.util.HashSet;

public class King extends Piece {

    public King(boolean isW, int r, int c){
        super(isW, r, c, Piece.KING);
        super.pointValue = -1;
    }

    // public String toString(){
    //     String reset = "\u001B[0m";
    // 	String black = "\u001B[30m";
    // 	String king = "\u2654";
    // 	String kingB = black + "\u265A";
    //     if (this.isWhite){
    //         return " " + king + " ";
    //     } else {
    //         return " " + kingB + " " + reset;
    //     }
    // }

    public boolean canMoveTo(Board gameBoard, String to){
        Piece[][] board = gameBoard.getChessBoard();
        HashSet<String> possibleMoves = new HashSet<String>();
        int[] possibleCols = {super.col, super.col, super.col - 1, super.col - 1, super.col - 1, super.col + 1, super.col + 1, super.col + 1};
        int[] possibleRows = {super.row - 1, super.row + 1, super.row - 1, super.row, super.row + 1, super.row - 1, super.row, super.row + 1};
        for (int i = 0; i < possibleRows.length; i++){
            if (possibleCols[i] >= 0 && possibleCols[i] <= 7 && possibleRows[i] >= 0 && possibleRows[i] <= 7){
                Piece p = board[possibleRows[i]][possibleCols[i]];
                if (p == null || p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(possibleCols[i]) + String.valueOf(8 - possibleRows[i]));
                }
            }
        }
        return possibleMoves.contains(to);
    }
}