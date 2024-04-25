import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        String[] cols = {"a", "b", "c", "d", "e", "f","g", "h"};
        int[] rows = {8, 7, 6, 5, 4, 3, 2, 1};
        HashSet<String> possibleSpots = new HashSet<>();
        for (int i = 0; i < cols.length; i++){
            for (int j = 0; j < rows.length; j++){
                possibleSpots.add(cols[i] + rows[j]);
            }
        }
        Board test = new Board();
        test.setup();
        System.out.println(test);
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (i < 100){ //testing loop - will change later
            System.out.println("Turn: " + ((test.getTurn()) ? "White" : "Black"));
            System.out.print("Enter from and to coordinatees separated with space: ");
            String from = input.next();
            String to = input.next();
            if (possibleSpots.contains(from) && possibleSpots.contains(to)){
                test.takeTurn(input.next(), input.next());
            } else {
                System.out.println("Invalid coordinates");
            }

            System.out.println("\n" + test);
            i++;
        }
    }



}
