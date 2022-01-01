package day05;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Navigator {

    public int calculateDangerousVentsOnOneLineIndex(List<VentDTO> vents) {

        var diagram = new HashMap<String, Integer>();

        vents.stream()
                .filter(VentDTO::isOnOneLine)
                .flatMap((Function<VentDTO, Stream<Vector>>) ventDTO -> ventDTO.getPointsForTheLine().stream())
                .forEach(coordinate -> diagram.merge(coordinate.getStringKey(), 1, Integer::sum));

        return (int) diagram.values().stream().filter(value -> value >= 2).count();

    }

    public int calculateDangerousVentsIndex(List<VentDTO> vents) {

        var diagram = new HashMap<String, Integer>();

        vents.stream()
                .flatMap((Function<VentDTO, Stream<Vector>>) ventDTO -> ventDTO.getPointsForTheLine().stream())
                .forEach(coordinate -> diagram.merge(coordinate.getStringKey(), 1, Integer::sum));

        return (int) diagram.values().stream().filter(value -> value >= 2).count();

    }

}
