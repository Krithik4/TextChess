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
}