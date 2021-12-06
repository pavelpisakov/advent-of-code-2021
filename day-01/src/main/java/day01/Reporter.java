package day01;

public class Reporter {

    public static void main(String[] args) throws Error {

        final Scanner scanner = new Scanner();
        final int[] report = scanner.performSonarSweep();

        final DepthAnalyzer depthAnalyzer = new ThreeMeasurementSlidingWindowDepthAnalyzer();
        System.out.println(depthAnalyzer.analyze(report));

    }

}
