package day02;

public class Submarine implements Movable {

    private int horizontalPosition = 0;
    private int depth = 0;

    public void forward(int units) {
        horizontalPosition += units;
    }

    public void down(int units) {
        depth += units;
    }

    public void up(int units) {
        depth -= units;
    }

    public int coordinate() {
        return horizontalPosition * depth;
    }

}
