import java.util.HashSet;

public class Knight extends Piece {

    public Knight(boolean isW, int r, int c){
        super(isW, r, c, Piece.KNIGHT);
        super.pointValue = 3;
    }

    public boolean canMoveTo(Board gameBoard, String to){
        Piece[][] board = gameBoard.getChessBoard();
        HashSet<String> possibleLocations = new HashSet<String>();
        if (super.row - 1 >= 0){
            if (super.col - 2 >= 0){
                possibleLocations.add(Board.revTranslations.get(super.col - 2) + String.valueOf(8 - (super.row - 1)));
            }
            if (super.col + 2 <= 7){
                possibleLocations.add(Board.revTranslations.get(super.col + 2) + String.valueOf(8 - (super.row - 1)));
            }
        }
        if (super.row + 1 <= 7){
            if (super.col - 2 >= 0){
                possibleLocations.add(Board.revTranslations.get(super.col - 2) + String.valueOf(8 - (super.row + 1)));
            }
            if (super.col + 2 <= 7){
                possibleLocations.add(Board.revTranslations.get(super.col + 2) + String.valueOf(8 - (super.row + 1)));
            }
        }
        if (super.row - 2 >= 0){
            if (super.col - 1 >= 0){
                possibleLocations.add(Board.revTranslations.get(super.col - 1) + String.valueOf(8 - (super.row - 2)));
            }
            if (super.col + 1 <= 7){
                possibleLocations.add(Board.revTranslations.get(super.col + 1) + String.valueOf(8 - (super.row - 2)));
            }
        }
        if (super.row + 2 <= 7){
            if (super.col - 1 >= 0){
                possibleLocations.add(Board.revTranslations.get(super.col - 1) + String.valueOf(8 - (super.row + 2)));
            }
            if (super.col + 1 <= 7){
                possibleLocations.add(Board.revTranslations.get(super.col + 1) + String.valueOf(8 - (super.row + 2)));
            }
        }

        HashSet<String> revisedSet = new HashSet<String>();
        for (String s : possibleLocations){
            int col = Board.translations.get(s.substring(0 ,1));
            int row = 8 - Integer.parseInt(s.substring(1, 2));
            if (board[row][col] == null){
                revisedSet.add(s);
            } else if (board[row][col].getColor() != this.isWhite){
                revisedSet.add(s);
            }
        }

        return revisedSet.contains(to);
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