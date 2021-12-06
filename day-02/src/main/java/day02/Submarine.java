package day02;

public interface Submarine {

    /**
     * Forward X increases the horizontal position by X units.
     */
    void forward(int units);

    /**
     * Down X increases the depth by X units.
     */
    void down(int units);

    /**
     * Up X decreases the depth by X units.
     */
    void up(int units);

    int coordinate();

}
