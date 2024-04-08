import java.util.HashSet;

public class Knight extends Piece {

    public Knight(boolean isW, int r, int c){
        super(isW, r, c, Piece.KNIGHT);
    }

    public boolean canMoveTo(Piece[][] board, String to){
        int toC = Board.translations.get(to.substring(0 ,1));
        int toR = 8 - Integer.parseInt(to.substring(1, 2));

        //possible rows -> r - 1
            //possible cols -> c - 2 or c + 2
        //possible rows -> r + 1
            //possible cols -> c - 2 or c + 2
        HashSet<String> possibleLocations = new HashSet<String>();
        if (super.row - 1 >= 0){
            //translate coords and add locations to set
        } else if (super.row + 1 <= 7){
            //translate coords and add locations to set
        } else if (super.row - 2 >= 0){
            //translate coords and add locations to set
        } else if (super.row + 2 <= 7){
            //translate coords and add locations to set
        }

        //then filter to see if those locations have same color piece


        return false;
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