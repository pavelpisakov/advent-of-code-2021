package day01;

import org.jetbrains.annotations.Contract;

public interface DepthAnalyzer {

    @Contract(value = "!null -> _; null -> fail", pure = true)
    int analyze(final int[] report);

}
