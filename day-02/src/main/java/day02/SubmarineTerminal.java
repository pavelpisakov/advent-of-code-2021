package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SubmarineTerminal implements Terminal {

    // The terminal knows how to get the data
    final private static String FILE_NAME = "input.txt";

    @Override
    public List<CommandDTO> readCommands() {

        final var stream = SubmarineTerminal.class.getClassLoader().getResourceAsStream(FILE_NAME);
        if (stream == null) {
            throw new Error("Can't get data. Check input devices.");
        }

        final var inputStreamReader = new InputStreamReader(stream);
        final var bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.lines().map(line -> {
            String[] tokens = line.split("\\s");
            if (tokens.length != 2) {
                throw new IllegalArgumentException("Can't parse the data");
            }
            return new CommandDTO(tokens[0], Integer.parseInt(tokens[1]));
        }).toList();

    }
}
