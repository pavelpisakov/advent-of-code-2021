package day04;

public class BoardNumber {

    private final int number;
    private boolean marked;

    public BoardNumber(int number) {
        this.number = number;
        this.marked = false;
    }

    public boolean isMarked() {
        return marked;
    }

    public int getNumber() {
        return number;
    }

    public void mark(Integer number) {
        if (this.number == number) {
            marked = true;
        }
    }
}
