package day02.command;

import day02.Submarine;

public record DownCommand(Submarine submarine, int units) implements MoveCommand {

    @Override
    public void execute() {
        submarine.down(this.units);
    }

}
