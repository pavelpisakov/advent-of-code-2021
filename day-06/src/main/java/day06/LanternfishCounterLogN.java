package day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LanternfishCounterLogN {

    // number-days -> total. The number of spawned fishes depends on both the
    // starting number and the number of days left, therefore we have to cache
    // based on both of them.
    private static final Map<String, Long> cache = new HashMap<>();

    public long countAll(String input, final int days) {
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                // delegate caching to the count method which is aware of the
                // number of days
                .map(number -> count(number, days))
                .reduce(Long::sum)
                .orElseThrow(() -> new Error("No values"));
    }

    // tenured: [6: 0]
    // new: [8: 0]
    // I may use the same function in recursion for spawns
    public long count(final int number, final int days) {

        String key = number + ":" + days;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // 1 is for the initial fish for which we are counting
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

        cache.put(key, total);
        return total;
    }

}
