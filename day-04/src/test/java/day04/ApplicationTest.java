package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    @Test
    public void testTheFirstBoard() {
        var submarine = new Submarine();
        var terminal = submarine.getTerminal();
        var bingoSubsystem = submarine.getBingoSubsystem();

        var input = terminal.getInput();
        System.out.println("input: " + input);

        var finalScore = bingoSubsystem.feed(terminal.getInput());
        System.out.println("final score: " + finalScore);

        assertEquals(4512, finalScore);
    }

    @Test
    public void testTheLastBoard() {
        var submarine = new Submarine();
        var terminal = submarine.getTerminal();
        var bingoSubsystem = submarine.getBingoSubsystem();

        var input = terminal.getInput();
        System.out.println("input: " + input);

        var finalScore = bingoSubsystem.feedToGetTheLastBoard(terminal.getInput());
        System.out.println("final score: " + finalScore);

        assertEquals(1924, finalScore);
    }
}