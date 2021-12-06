package day02.command;

import day02.Movable;

public record DownCommand(Movable movable, int units) implements MoveCommand {

    @Override
    public void execute() {
        movable.down(this.units);
    }

}
