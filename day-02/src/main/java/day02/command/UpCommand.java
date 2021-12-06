package day02.command;

import day02.Submarine;

public record UpCommand(Submarine submarine, int units) implements MoveCommand {

    @Override
    public void execute() {
        submarine.up(this.units);
    }

}
