package day02;

public class AimableSubmarine implements Submarine {

    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;

    public synchronized void forward(int units) {
        horizontalPosition += units;
        depth += aim * units;
    }

    public void down(int units) {
        aim += units;
    }

    public void up(int units) {
        aim -= units;
    }

    @Override
    public int coordinate() {
        return horizontalPosition * depth;
    }

}
