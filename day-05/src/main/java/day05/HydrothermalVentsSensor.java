package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HydrothermalVentsSensor {

    // The submarine knows where to get the data
    final private static String FILE_NAME = "input.txt";

    public List<VentDTO> readData() {
        final var stream = HydrothermalVentsSensor.class.getClassLoader().getResourceAsStream(FILE_NAME);
        if (stream == null) {
            throw new Error("Can't get data. Check input devices.");
        }

        final var inputStreamReader = new InputStreamReader(stream);
        final var bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.lines()
                .map(VentDTO::new)
                .collect(Collectors.toList());
    }

}
