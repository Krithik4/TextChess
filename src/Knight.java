public class Knight extends Piece {

    public Knight(boolean isW, int r, int c){
        super(isW, r, c, Piece.KNIGHT);
    }

    // public String toString(){
    //     String reset = "\u001B[0m";
    // 	String black = "\u001B[30m";
    // 	String knight = "\u2658";
    // 	String knightB = black + "\u265E";
    //     if (this.isWhite){
    //         return " " + knight + " ";
    //     } else {
    //         return " " + knightB + " " + reset;
    //     }
    // }
}