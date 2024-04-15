public class Queen extends Piece {

    public Queen(boolean isW, int r, int c){
        super(isW, r, c, Piece.QUEEN);
        super.pointValue = 9;
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