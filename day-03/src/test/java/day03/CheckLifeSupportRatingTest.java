package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckLifeSupportRatingTest {

    @Test
    public void compareTestData() {

        var submarine = new CrackingSubmarine();
        var report = submarine.produceDiagnosticReportAsString();

        var powerConsumption = submarine.checkLifeSupportRating(report);
        assertEquals(230, powerConsumption);

    }
}
