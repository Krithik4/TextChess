public class Rook extends Piece {

    public Rook(boolean isW, int r, int c){
        super(isW, r, c, Piece.ROOK);
        super.pointValue = 5;
    }

    public boolean canMoveTo(Board gameBoard, String to){
        Piece[][] board = gameBoard.getChessBoard();


        return false;
    }

    // public String toString(){
    //     String reset = "\u001B[0m";
    // 	String black = "\u001B[30m";
    // 	String rook = "\u2656";
    // 	String rookB = black + "\u265C";
    //     if (this.isWhite){
    //         return " " + rook + " ";
    //     } else {
    //         return " " + rookB + " " + reset;
    //     }
    // }
}