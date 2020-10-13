package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class SumDigPower {
    private static List<Long> result;

    public static List<Long> sumDigPow(Long a, Long b) {
        result = new ArrayList<>();
        LongStream.rangeClosed(a,b).forEach(SumDigPower::checkCompatibility);
        return result;
    }

    private static void checkCompatibility(long n) {
        String numberAsText = n + "";
        double sum = 0l;

        String[] split = numberAsText.split("");
        for (int i = 0; i < split.length; i++) {
            sum += Math.pow(Long.parseLong(split[i]), i+1);
        }

        if (sum == n)
        result.add(n);
    }
}
