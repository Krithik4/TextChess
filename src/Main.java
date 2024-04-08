
public class Main
{
    public static void main(String[] args) {
        Board test = new Board();
        test.setup();
        System.out.println(test);
        String from = "b1";
        String to = "c3";
        test.takeTurn(from, to);
        System.out.println("\n" + test);
    }


}
