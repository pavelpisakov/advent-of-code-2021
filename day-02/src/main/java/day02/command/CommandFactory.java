package day02.command;

import day02.Movable;
import org.jetbrains.annotations.NotNull;

public class CommandFactory {

    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";

    public MoveCommand getCommand(@NotNull Movable movable, @NotNull String type, int units) {
        return switch (type) {
            case FORWARD -> new ForwardCommand(movable, units);
            case DOWN -> new DownCommand(movable, units);
            case UP -> new UpCommand(movable, units);
            default -> throw new IllegalArgumentException("Unknown command type");
        };
    }
}
