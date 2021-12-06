package day02.command;

import day02.Movable;

public record ForwardCommand(Movable movable, int units) implements MoveCommand {

    @Override
    public void execute() {
        movable.forward(this.units);
    }

}
