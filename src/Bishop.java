public class Bishop extends Piece {

    public Bishop(boolean isW, int r, int c){
        super(isW, r, c, Piece.BISHOP);
        super.pointValue = 3;
    }

    // public String toString(){
    //     String reset = "\u001B[0m";
    // 	String black = "\u001B[30m";
    // 	String bishop = "\u2657";
    // 	String bishopB = black + "\u265D";
    //     if (this.isWhite){
    //         return " " + bishop + " ";
    //     } else {
    //         return " " + bishopB + " " + reset;
    //     }
    // }
}