public class Pawn extends Piece {

    public Pawn(boolean isW, int r, int c){
        super(isW, r, c, Piece.PAWN);
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
}