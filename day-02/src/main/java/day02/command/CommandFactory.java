package day02.command;

import day02.Submarine;
import org.jetbrains.annotations.NotNull;

public class CommandFactory {

    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";

    public MoveCommand getCommand(@NotNull Submarine submarine, @NotNull String type, int units) {
        return switch (type) {
            case FORWARD -> new ForwardCommand(submarine, units);
            case DOWN -> new DownCommand(submarine, units);
            case UP -> new UpCommand(submarine, units);
            default -> throw new IllegalArgumentException("Unknown command type");
        };
    }
}
