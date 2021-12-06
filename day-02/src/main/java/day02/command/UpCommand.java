package day02.command;

import day02.Movable;

public record UpCommand(Movable movable, int units) implements MoveCommand {

    @Override
    public void execute() {
        movable.up(this.units);
    }

}
