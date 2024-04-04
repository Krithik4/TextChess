
public class Main
{
    public static void main(String[] args) {
        Board test = new Board();
        test.setup();
        System.out.println(test);
        String from = "b1";
        if (test.piecePresent(from)){
            test.takeTurn(from, "a3");
        }
        System.out.println("\n" + test);
    }


}
