package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

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

        final List<CommandDTO> input = new LinkedList<>();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\s");
                if (tokens.length != 2) {
                    throw new IllegalArgumentException("Can't parse the data");
                }
                final CommandDTO commandDTO = new CommandDTO(tokens[0], Integer.parseInt(tokens[1]));
                input.add(commandDTO);
            }
        } catch (IllegalArgumentException | IOException exception) {
            throw new Error("Can't parse the data", exception);
        }

        return input;

    }
}
