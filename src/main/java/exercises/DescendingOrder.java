package exercises;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        String collect = Arrays.stream(String.valueOf(num).split(""))
                .filter(digit -> digit.charAt(0) >= '0' || digit.charAt(0) <= '9')
                .sorted((d1, d2) -> Integer.parseInt(d2) - Integer.parseInt(d1))
                .collect(Collectors.joining());
        return Integer.parseInt(collect);
    }
}
