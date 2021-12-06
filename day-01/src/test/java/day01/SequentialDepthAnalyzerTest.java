package day01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SequentialDepthAnalyzerTest {

    @Test
    public void validateEmptyInput_equalTo_0() {
        final int[] input = new int[] {};
        final DepthAnalyzer depthAnalyzer = new SequentialDepthAnalyzer();
        assertEquals(0, depthAnalyzer.analyze(input));
    }

    @Test
    public void validateSingleValueinInput_equalTo_0() {
        final int[] input = new int[] {199};
        final DepthAnalyzer depthAnalyzer = new SequentialDepthAnalyzer();
        assertEquals(0, depthAnalyzer.analyze(input));
    }

    @Test
    public void validateTestInput_equalTo_7() {
        final int[] input = new int[] {199, 200, 208, 210, 200, 207, 240, 269, 260, 263};
        final DepthAnalyzer depthAnalyzer = new SequentialDepthAnalyzer();
        assertEquals(7, depthAnalyzer.analyze(input));
    }

}