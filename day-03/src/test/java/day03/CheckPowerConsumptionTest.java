package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckPowerConsumptionTest {

    @Test
    public void compareTestData() {

        var submarine = new CrackingSubmarine();
        var report = submarine.produceDiagnosticReport();

        var powerConsumption = submarine.checkPowerConsumption(report);
        assertEquals(230, powerConsumption);

    }
}
