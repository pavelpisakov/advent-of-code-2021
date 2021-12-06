package day01;

public class ThreeMeasurementSlidingWindowDepthAnalyzer implements DepthAnalyzer {

    @Override
    public int analyze(int[] report) {

        if (report == null) {
            throw new NullPointerException("The report shouldn't be empty");
        }

        int count = 0;

        // If the report is empty or contain only one element - return 0 measurements
        // that are larger than the previous measurement.
        if (report.length < 4) {
            return count;
        }

        int oldSum = report[0] + report[1] + report[2];

        for (int i = 1; i < report.length - 2; i++) {
            final int newSum = oldSum - report[i - 1] + report[i + 2];
            if (newSum > oldSum) {
                count++;
            }
            oldSum = newSum;
        }

        return count;

    }

}
