package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Performs sonar sweep and provides a report.
 */
public class Scanner {

    // The scanner knows how to get the data
    final private static String FILE_NAME = "input.txt";

    public int[] performSonarSweep() throws Error {

        final var stream = Reporter.class.getClassLoader().getResourceAsStream(FILE_NAME);
        if (stream == null) {
            throw new Error("Can't get data. Check sensors.");
        }

        final var inputStreamReader = new InputStreamReader(stream);
        final var bufferedReader = new BufferedReader(inputStreamReader);

        final List<Integer> input = new LinkedList<>();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                input.add(Integer.parseInt(line));
            }
        } catch (IOException exception) {
            throw new Error("Can't parse the data");
        }

        return input.stream().mapToInt(i -> i).toArray();

    }

}
