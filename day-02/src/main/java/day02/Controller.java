package day02;

import day02.command.CommandFactory;
import day02.command.MoveCommand;
import java.util.List;

public class Controller {

    private final Terminal terminal;
    private final Submarine submarine;
    private final CommandFactory commandFactory;

    public Controller(final Terminal terminal, final Submarine submarine) {
        this.terminal = terminal;
        this.submarine = submarine;
        commandFactory = new CommandFactory();
    }

    // this function runs commands on a submarine and mutates its' state
    public void pilot() {

        // Read commands from the terminal
        final List<CommandDTO> stringCommands = terminal.readCommands();

        // Transform
        final List<MoveCommand> commands = stringCommands.stream()
                .map(commandDTO -> commandFactory.getCommand(submarine, commandDTO.name(), commandDTO.unit()))
                .toList();

        // Execute commands and modify the state of a submarine
        commands.forEach(MoveCommand::execute);

    }

    public int whereWeAre() {
        return submarine.coordinate();
    }

}
