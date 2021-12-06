package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeMeasurementSlidingWindowDepthAnalyzerTest {

    @Test
    public void validateEmptyInput_equalTo_0() {
        final int[] input = new int[] {};
        final DepthAnalyzer depthAnalyzer = new ThreeMeasurementSlidingWindowDepthAnalyzer();
        assertEquals(0, depthAnalyzer.analyze(input));
    }

    @Test
    public void validateSingleValueinInput_equalTo_0() {
        final int[] input = new int[] {607};
        final DepthAnalyzer depthAnalyzer = new ThreeMeasurementSlidingWindowDepthAnalyzer();
        assertEquals(0, depthAnalyzer.analyze(input));
    }

    @Test
    public void validateTestInput_equalTo_5() {
        final int[] input = new int[] {607, 618, 618, 617, 647, 716, 769, 792};
        final DepthAnalyzer depthAnalyzer = new ThreeMeasurementSlidingWindowDepthAnalyzer();
        assertEquals(5, depthAnalyzer.analyze(input));
    }

    @Test
    public void validateTestInputOfTwoElements_equalTo_1() {
        final int[] input = new int[] {607, 618};
        final DepthAnalyzer depthAnalyzer = new ThreeMeasurementSlidingWindowDepthAnalyzer();
        assertEquals(0, depthAnalyzer.analyze(input));
    }

    @Test
    public void validateTestInputOfFourElements_equalTo_1() {
        final int[] input = new int[] {607, 618, 618, 617};
        final DepthAnalyzer depthAnalyzer = new ThreeMeasurementSlidingWindowDepthAnalyzer();
        assertEquals(1, depthAnalyzer.analyze(input));
    }

}