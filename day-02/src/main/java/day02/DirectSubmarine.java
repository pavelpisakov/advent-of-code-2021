package day02;

public class DirectSubmarine implements Submarine {

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

    @Override
    public int coordinate() {
        return horizontalPosition * depth;
    }

}
