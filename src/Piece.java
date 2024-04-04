public class Piece {
    protected boolean isWhite;
    protected int row;
    protected int col;
    protected String pieceChar;

    public static final String PAWN = "\u265F";
    public static final String KNIGHT = "\u265E";
    public static final String BISHOP = "\u265D";
    public static final String ROOK = "\u265C";
    public static final String QUEEN = "\u265B";
    public static final String KING = "\u265A";

    public Piece(boolean isW, int r, int c, String pChar){
        this.isWhite = isW;
        this.row = r;
        this.col = c;
        this.pieceChar = pChar;
    }

    public String toString(){
        return " " + (this.isWhite ? "" : Colors.BLACK) + this.pieceChar + " " + Colors.RESET;
    }
}