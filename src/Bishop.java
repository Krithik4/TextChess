public class Bishop extends Piece {

    public Bishop(boolean isW, int r, int c){
        super(isW, r, c, Piece.BISHOP);
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