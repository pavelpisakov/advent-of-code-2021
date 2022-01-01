package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    public void calculateDangerousVentsOnOneLineIndex_shouldMatch5() {

        var submarine = new Submarine();
        var sensor = submarine.getHydrothermalVentsSensor();
        var data = sensor.readData();

        var navigator = submarine.getNavigator();
        int index = navigator.calculateDangerousVentsOnOneLineIndex(data);

        assertEquals(5, index);
    }

    @Test
    public void calculateDangerousVentsIndex_shouldMatch12() {

        var submarine = new Submarine();
        var sensor = submarine.getHydrothermalVentsSensor();
        var data = sensor.readData();

        var navigator = submarine.getNavigator();
        int index = navigator.calculateDangerousVentsIndex(data);

        assertEquals(12, index);
    }

}