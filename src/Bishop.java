import java.util.HashSet;

public class Bishop extends Piece {

    public Bishop(boolean isW, int r, int c){
        super(isW, r, c, Piece.BISHOP);
        super.pointValue = 3;
    }

    public boolean canMoveTo(Board gameBoard, String to){
        Piece[][] board = gameBoard.getChessBoard();
        int toC = Board.translations.get(to.substring(0 ,1));
        int toR = 8 - Integer.parseInt(to.substring(1, 2));
        HashSet<String> possibleMoves = new HashSet<String>();
        int tempRow = this.row;
        int tempCol = this.col;

        if (toC > this.col && toR > this.row){
            while (tempRow < 7 && tempCol < 7){
                Piece p = board[++tempRow][++tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempCol = tempRow = 8;
                } else if (p.getColor() == this.isWhite){
                    tempCol = tempRow = 8;
                }
            }
        }
        if (toC < this.col && toR > this.row){
            while (tempRow < 7 && tempCol > 0){
                Piece p = board[++tempRow][--tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempRow = 8;
                    tempCol = -1;
                } else if (p.getColor() == this.isWhite){
                    tempRow = 8;
                    tempCol = -1;
                }
            }
        }
        if (toC > this.col && toR < this.row){
            while (tempRow > 0 && tempCol < 7){
                Piece p = board[--tempRow][++tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempCol = 8;
                    tempRow = -1;
                } else if (p.getColor() == this.isWhite){
                    tempCol = 8;
                    tempRow = -1;
                }
            }
        }
        if (toC < this.col && toR < this.row){
            while (tempRow > 0 && tempCol > 0){
                Piece p = board[--tempRow][--tempCol];
                if (p == null){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                } else if (p.getColor() != this.isWhite){
                    possibleMoves.add(Board.revTranslations.get(tempCol) + String.valueOf(8 - tempRow));
                    tempCol = tempRow = -1;
                } else if (p.getColor() == this.isWhite){
                    tempCol = tempRow = -1;
                }
            }
        }
        return possibleMoves.contains(to);
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