package day02;

public interface Movable {

    /**
     * Forward X increases the horizontal position by X units.
     * @param units
     */
    void forward(int units);

    /**
     * Down X increases the depth by X units.
     * @param units
     */
    void down(int units);

    /**
     * Up X decreases the depth by X units.
     * @param units
     */
    void up(int units);

}
