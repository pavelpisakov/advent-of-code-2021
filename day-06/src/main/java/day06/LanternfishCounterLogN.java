package day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LanternfishCounterLogN {

    // number, total
    private static final Map<Integer, Long> cache = new HashMap<>();

    public long countAll(String input, final int days) {
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .map(number -> {
                    if (cache.containsKey(number)) {
                        return cache.get(number);
                    }
                    long count = count(number, days);
                    cache.put(number, count);
                    return count;
                })
                .reduce(Long::sum)
                .orElseThrow(() -> new Error("No values"));
    }

    // tenured: [6: 0]
    // new: [8: 0]
    // I may use the same function in recursion for spawns
    public long count(final int number, final int days) {

        // 1 is for the initial, for which we are counting
        long total = 1;

        // I need to know when the 1st child is spawned
        int remainDays = days - (number + 1);

        // check if we out of bound
        while (remainDays >= 0) {
            // here we spawned one fish and we can calculate is separately
            long spawned = count(8, remainDays);
            total += spawned;
            remainDays -= 7;
        }

        return total;
    }

}
