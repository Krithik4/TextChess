
public class Main
{
    public static void main(String[] args) {
        Board test = new Board();
        test.setup();
        System.out.println(test);
        String from = "c2";
        String to = "c4";
        test.takeTurn(from, to);
        System.out.println("\n" + test);
        test.takeTurn("a7", "a5");
        System.out.println("\n" + test);
        test.takeTurn("c4", "c5");
        System.out.println("\n" + test);
        test.takeTurn("a5", "a4");
        System.out.println("\n" + test);
        test.takeTurn("c5", "c6");
        System.out.println("\n" + test);
        test.takeTurn("c7", "c5");
        System.out.println("\n" + test);

    }


}
