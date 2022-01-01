package day05;

import java.util.ArrayList;
import java.util.List;

public class VentDTO {

    private final Vector start;
    private final Vector end;

    // supported format: 0,9 -> 5,9, like, x1,y1 -> x2,y2
    public VentDTO(String line) {

        if (line == null) {
            throw new IllegalArgumentException("Line must follow the patter: x1,y1 -> x2,y2");
        }

        String[] coordinates = line.strip().split("\\s->\\s");
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Line must follow the patter: x1,y1 -> x2,y2");
        }

        String[] coordinate1 = coordinates[0].split(",");
        String[] coordinate2 = coordinates[1].split(",");

        if (coordinate1.length != 2 || coordinate2.length != 2) {
            throw new IllegalArgumentException("Line must follow the patter: x1,y1 -> x2,y2");
        }

        start = new Vector(Integer.parseInt(coordinate1[0]), Integer.parseInt(coordinate1[1]));
        end = new Vector(Integer.parseInt(coordinate2[0]), Integer.parseInt(coordinate2[1]));

    }

    public List<Vector> getPointsForTheLine() {

        final List<Vector> points = new ArrayList<>();

        var dynamic = start.copy();
        var vector = dynamic.getDirection(end);

        points.add(dynamic.copy());

        while (!dynamic.equals(end)) {
            dynamic.add(vector);
            points.add(dynamic.copy());
        }

        return points;
    }

    @Override
    public String toString() {
        return "VentDTO{" +
               "start=" + start +
               ", end=" + end +
               '}';
    }

    public boolean isOnOneLine() {
        return start.isHorizontal(end) || start.isVertical(end);
    }

}
