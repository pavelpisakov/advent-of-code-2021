package day02;

public class Application {

    public static void main(String[] args) {

        final Terminal terminal = new SubmarineTerminal();
        final Submarine submarine = new Submarine();
        final Controller controller = new Controller(terminal, submarine);

        controller.pilot();
        System.out.println(controller.whereWeAre());

    }
}
