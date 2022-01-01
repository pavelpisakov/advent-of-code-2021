package day04;

public class Application {

    public static void main(String[] args) {

        var submarine = new Submarine();
        var terminal = submarine.getTerminal();
        var bingoSubsystem = submarine.getBingoSubsystem();

        var input = terminal.getInput();
        System.out.println("input: " + input);

        var finalScore = bingoSubsystem.feedToGetTheLastBoard(terminal.getInput());
        System.out.println("final score: " + finalScore);

    }
}
