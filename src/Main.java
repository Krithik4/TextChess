
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
        test.takeTurn("b7", "b5");
        System.out.println("\n" + test);
        test.takeTurn("c4", "b5");
        System.out.println("\n" + test);
        test.takeTurn("d7", "d5");
        System.out.println("\n" + test);
        test.takeTurn("b5", "b6");
        System.out.println("\n" + test);
        test.takeTurn("d5", "d4");
        System.out.println("\n" + test);
        test.takeTurn("b6", "a7");
        System.out.println("\n" + test);
        test.takeTurn("d4", "d3");
        System.out.println("\n" + test);
        test.takeTurn("a7", "b8");
        System.out.println("\n" + test);


    }


}
