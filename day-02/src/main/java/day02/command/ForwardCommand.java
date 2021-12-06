package day02.command;

import day02.Submarine;

public record ForwardCommand(Submarine submarine, int units) implements MoveCommand {

    @Override
    public void execute() {
        submarine.forward(this.units);
    }

}
