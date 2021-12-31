package day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CrackingSubmarine implements Submarine {

    // The submarine knows where to get the data
    final private static String FILE_NAME = "input.txt";

    @Override
    public List<Integer> produceDiagnosticReport() {
        return produceDiagnosticReportAsString().stream()
                .map(binaryString -> Integer.parseInt(binaryString, 2))
                .toList();
    }

    @Override
    public List<String> produceDiagnosticReportAsString() {
        final var stream = CrackingSubmarine.class.getClassLoader().getResourceAsStream(FILE_NAME);
        if (stream == null) {
            throw new Error("Can't get data. Check input devices.");
        }

        final var inputStreamReader = new InputStreamReader(stream);
        final var bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.lines().toList();
    }

    @Override
    public int checkPowerConsumption(List<Integer> report) {

        TreeMap<Integer, Integer> buckets = new TreeMap<>();

        // bucket 0 is the last bit, bucket n is the first bit
        for (Integer value: report) {
            int bucket = 0;
            while (value != 0) {
                if ((value & 1) == 1) {
                    buckets.merge(bucket, 1, Integer::sum);
                }
                value = value >> 1;
                bucket++;
            }
        }

        final int half = report.size() / 2;
        // it is important to have the size
        int gamma = 0;
        System.out.println(buckets);
        for (int i = buckets.lastKey(); i >= 0; i--) {
            var value = buckets.getOrDefault(i, 0);
            if (value > half) {
                gamma += 1;
            }
            if (i != 0) {
                gamma <<= 1;
            }
        }

        final int mask = ((int) Math.pow(2, buckets.lastKey() + 1)) - 1;
        final int epsilon = (~gamma) & mask;
        return gamma * epsilon;

    }

    @Override
    public int checkLifeSupportRating(List<String> report) {
        final int mostCommonBits = Integer.parseInt(iterate(report, true), 2);
        final int leastCommonBits = Integer.parseInt(iterate(report, false), 2);

        return mostCommonBits * leastCommonBits;
    }

    private String iterate(final List<String> report, final boolean mostCommon) {
        List<String> filtered = report;
        int depth = 0;
        do {
            filtered = filter(filtered, mostCommon, depth);
            depth++;
        } while (filtered.size() != 1);
        return filtered.get(0);
    }
    private List<String> filter(final List<String> report, final boolean mostCommon, final int depth) {

        List<String> listWith1 = new ArrayList<>();
        List<String> listWith0 = new ArrayList<>();
        for (String value: report) {
            if (value.charAt(depth) == '1') {
                listWith1.add(value);
            } else {
                listWith0.add(value);
            }
        }
        List<String> result;

        if (mostCommon) {
            if (listWith1.size() >= listWith0.size()) {
                result = listWith1;
            } else {
                result = listWith0;
            }
        } else {
            if (listWith0.size() <= listWith1.size()) {
                result = listWith0;
            } else {
                result = listWith1;
            }
        }

        return result;
    }
}
