package day04;

public class BingoSubsystem {

    public int feed(BingoDTO input) {

        for (var number: input.getRandomNumbers()) {
            for (var board: input.getBoards()) {
                boolean bingo = board.check(number);
                if (bingo) {
                    return board.getFinalScore(number);
                }
            }
        }
        throw new Error("No enough number");
    }

    public int feedToGetTheLastBoard(BingoDTO input) {

        int totalBoards = input.getBoards().size();
        int boardsThatWon = 0;

        for (var number: input.getRandomNumbers()) {
            for (var board: input.getBoards()) {
                if (!board.isWon()) { // if it already won, no checks
                    boolean bingo = board.check(number);
                    if (bingo) {
                        boardsThatWon++;
                    }
                    if (boardsThatWon == totalBoards) {
                        return board.getFinalScore(number);
                    }
                }

            }
        }
        throw new Error("No enough number");
    }


}
