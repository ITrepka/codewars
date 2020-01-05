package exercises;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimesPG13 {
    private static final int CROSSED_OUT = -1;
    public static IntStream stream() {
        return primesLessThanErastotenes(50_000_000);
    }

    public static IntStream primesLessThanErastotenes(int n) {
        int[] numbers = IntStream.range(2, n).toArray();
        for (int i = 0; numbers[i] <= Math.sqrt(n); i++) {
            if (numbers[i] != CROSSED_OUT) {
                for (int j = i + numbers[i]; j < numbers.length; j = j + numbers[i]) {
                    numbers[j] = CROSSED_OUT;
                }
            }
        }
        return Arrays.stream(numbers)
                .filter(number -> number != CROSSED_OUT);
    }
}
