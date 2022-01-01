package day04;

import java.util.Arrays;
import java.util.List;

public class BingoDTO {

    private final List<Integer> randomNumbers;
    private final List<Board> boards;

    public BingoDTO(String randomNumbers, List<Board> boards) {
        this.randomNumbers = Arrays.stream(randomNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

        this.boards = boards;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public List<Board> getBoards() {
        return boards;
    }

    @Override
    public String toString() {
        return "BingoDTO{" +
               "randomNumbers=" + randomNumbers +
               ", boards=" + boards +
               '}';
    }
}
