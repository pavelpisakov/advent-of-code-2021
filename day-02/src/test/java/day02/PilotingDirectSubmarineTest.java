package day02;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilotingDirectSubmarineTest {

    @Test
    void testInputData_mustEqualTo_150() {

        final Terminal terminal = () -> Arrays.asList(
                new CommandDTO("forward", 5),
                new CommandDTO("down", 5),
                new CommandDTO("forward", 8),
                new CommandDTO("up", 3),
                new CommandDTO("down", 8),
                new CommandDTO("forward", 2)
        );

        final Submarine submarine = new DirectSubmarine();

        Controller controller = new Controller(terminal, submarine);
        controller.pilot();

        assertEquals(150, controller.whereWeAre());

    }
}