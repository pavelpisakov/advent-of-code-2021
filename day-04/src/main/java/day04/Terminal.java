package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Terminal {

    // The submarine knows where to get the data
    final private static String FILE_NAME = "input.txt";

    public BingoDTO getInput() {
        final var stream = Terminal.class.getClassLoader().getResourceAsStream(FILE_NAME);
        if (stream == null) {
            throw new Error("Can't get data. Check input devices.");
        }

        final var inputStreamReader = new InputStreamReader(stream);
        final var bufferedReader = new BufferedReader(inputStreamReader);

        BingoDTO bingoDTO;
        try {

            List<Board> boards = new ArrayList<>();
            String randomNumbers = bufferedReader.readLine();
            List<String> dataForADeck = new ArrayList<>();
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    boards.add(new Board(dataForADeck));
                    dataForADeck = new ArrayList<>();
                } else {
                    dataForADeck.add(line);
                }
            }
            if (dataForADeck.size() > 0) {
                boards.add(new Board(dataForADeck));
            }

            bingoDTO = new BingoDTO(randomNumbers, boards);

        } catch (IOException exception) {
            throw new Error("Can't read the data. Check input devices.");
        }

        return bingoDTO;

    }

}
