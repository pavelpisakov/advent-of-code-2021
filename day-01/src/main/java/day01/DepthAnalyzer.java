package day01;

import org.jetbrains.annotations.Contract;

public class DepthAnalyzer {

    @Contract(value = "!null -> _; null -> fail", pure = true)
    public int analyze(final int[] report) {

        if (report == null) {
            throw new NullPointerException("The report shouldn't be empty");
        }

        int count = 0;

        // If the report is empty or contain only one element - return 0 measurements
        // that are larger than the previous measurement.
        if (report.length < 2) {
            return count;
        }

        int previous = report[0];

        for (int i = 1; i < report.length; i++) {
            if (report[i] > previous) {
                count++;
            }
            previous = report[i];
        }

        return count;
    }
}
