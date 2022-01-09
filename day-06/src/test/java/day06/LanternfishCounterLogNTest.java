package day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanternfishCounterLogNTest {

    @Test
    public void boundaryTest() {
        var counter = new LanternfishCounterLogN();
        assertEquals(1, counter.count(3, 1));
        assertEquals(1, counter.count(3, 2));
        assertEquals(1, counter.count(3, 3));
        assertEquals(2, counter.count(3, 4));
        assertEquals(2, counter.count(3, 10));
        assertEquals(3, counter.count(3, 11));
        assertEquals(3, counter.count(3, 12));
        assertEquals(4, counter.count(3, 13));
    }

    @Test
    public void testInput_mustBeEqualTo26() {
        var counter = new LanternfishCounterLogN();
        assertEquals(5934, counter.countAll("3,4,3,1,2", 18));
    }

    private final String TEST_INPUT = "1,1,1,1,2,1,1,4,1,4,3,1,1,1,1,1,1,1,1,4,1,3,1,1,1,5,1,3,1,4,1,2,1,1,5,1,1,1,1,1,1,1,1,1,1,3,4,1,5,1,1,1,1,1,1,1,1,1,3,1,4,1,1,1,1,3,5,1,1,2,1,1,1,1,4,4,1,1,1,4,1,1,4,2,4,4,5,1,1,1,1,2,3,1,1,4,1,5,1,1,1,3,1,1,1,1,5,5,1,2,2,2,2,1,1,2,1,1,1,1,1,3,1,1,1,2,3,1,5,1,1,1,2,2,1,1,1,1,1,3,2,1,1,1,4,3,1,1,4,1,5,4,1,4,1,1,1,1,1,1,1,1,1,1,2,2,4,5,1,1,1,1,5,4,1,3,1,1,1,1,4,3,3,3,1,2,3,1,1,1,1,1,1,1,1,2,1,1,1,5,1,3,1,4,3,1,3,1,5,1,1,1,1,3,1,5,1,2,4,1,1,4,1,4,4,2,1,2,1,3,3,1,4,4,1,1,3,4,1,1,1,2,5,2,5,1,1,1,4,1,1,1,1,1,1,3,1,5,1,2,1,1,1,1,1,4,4,1,1,1,5,1,1,5,1,2,1,5,1,1,1,1,1,1,1,1,1,1,1,1,3,2,4,1,1,2,1,1,3,2";

    @Test
    public void taskTest1() {
        var counter = new LanternfishCounterLogN();
        assertEquals(386536L, counter.countAll(TEST_INPUT, 80));
    }

    @Test
    public void taskTest2() {
        var counter = new LanternfishCounterLogN();
        assertEquals(1732821262171L, counter.countAll(TEST_INPUT, 256));
    }

}