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
        int toC = Board.translations.get(to.substring(0 ,1));
        int toR = 8 - Integer.parseInt(to.substring(1, 2));

//        if (onHomeRow){
//            if (this.isWhite){
//                if ((toR - this.row == -2 || toR - this.row == -1) && toC == this.col){
//                    return true;
//                }
//            } else {
//                if ((toR - this.row == 2 || toR - this.row == 1) && toC == this.col){
//                    return true;
//                }
//            }
//        } else {
//            if (this.isWhite){
//                if (toR - this.row == -1 && toC == this.col){
//                    return true;
//                }
//            } else {
//                if (toR - this.row == 1 && toC == this.col){
//                    return true;
//                }
//            }
//        }

        if (onHomeRow){
            if (this.isWhite){
                possibleMoves.add(Board.revTranslations.get(toC) + String.valueOf(8 - (this.row - 2)));
                possibleMoves.add(Board.revTranslations.get(toC) + String.valueOf(8 - (this.row - 1)));
            } else {
                possibleMoves.add(Board.revTranslations.get(toC) + String.valueOf(8 - (this.row + 2)));
                possibleMoves.add(Board.revTranslations.get(toC) + String.valueOf(8 - (this.row + 1)));
            }
        } else {
            if (this.isWhite){
                possibleMoves.add(Board.revTranslations.get(toC) + String.valueOf(8 - (this.row - 1)));
            } else {
                possibleMoves.add(Board.revTranslations.get(toC) + String.valueOf(8 - (this.row + 1)));
            }
        }
        HashSet<String> revisedSet = new HashSet<String>();

        for (String s : possibleMoves){
            if (!gameBoard.piecePresent(s)){
                revisedSet.add(s);
            }
        }
        return revisedSet.contains(to);
    }
}