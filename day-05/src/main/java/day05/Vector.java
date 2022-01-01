package day05;

import java.util.Objects;

// The coordinates of one end the line segment
public class Vector {

    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getStringKey() {
        return x + "," + y;
    }

    public Vector copy() {
        return new Vector(this.x, this.y);
    }

    public Vector getDirection(Vector end) {

        int horizontalShift = Integer.compare(end.x, this.x);
        int verticalShift = Integer.compare(end.y, this.y);

        return new Vector(horizontalShift, verticalShift);

    }

    public void add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public boolean isHorizontal(Vector end) {
        return this.x == end.x;
    }

    public boolean isVertical(Vector end) {
        return this.y == end.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return x == vector.x && y == vector.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }

}
