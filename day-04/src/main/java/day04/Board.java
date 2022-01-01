package day04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private final List<List<BoardNumber>> data;
    private boolean won = false;

    public Board(final List<String> row) {
        data = row.stream()
                .map(line ->
                        Arrays.stream(line.strip().split("\\s+"))
                                .map(value -> new BoardNumber(Integer.parseInt(value)))
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public boolean isWon() {
        return won;
    }

    public boolean check(Integer number) {
        if (checkRows(number) || checkColumns(number)) {
            won = true;
        }
        return won;
    }

    private boolean checkRows(Integer number) {
        for (var row: data) {
            int matched = 0;
            for (var boardNumber: row) {
                boardNumber.mark(number);
                if (boardNumber.isMarked()) {
                    matched++;
                }
            }
            if (row.size() == matched) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(Integer number) {
        // go by columns
        for (int columnIndex = 0; columnIndex < data.get(0).size(); columnIndex++) {
            int matched = 0;
            for (var row: data) {
                var boardNumber = row.get(columnIndex);
                boardNumber.mark(number);
                if (boardNumber.isMarked()) {
                    matched++;
                }
            }
            if (data.size() == matched) {
                return true;
            }
        }
        return false;
    }

    public int getFinalScore(Integer number) {
        int sumOfAllUnmarkedNumbers = 0;
        for (var row: data) {
            for (var element: row) {
                if (!element.isMarked()) {
                    sumOfAllUnmarkedNumbers += element.getNumber();
                }
            }
        }
        System.out.println("sum of all unmarked numbers: " + sumOfAllUnmarkedNumbers);
        return sumOfAllUnmarkedNumbers * number;
    }

    @Override
    public String toString() {
        return "Board{" +
               "data=" + data +
               '}';
    }

}
