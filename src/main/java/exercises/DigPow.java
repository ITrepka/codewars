package exercises;

import java.util.Arrays;

public class DigPow {
    public static long digPow(int n, int p) {
        // your code
        String[] digitArr = String.valueOf(n).split("");
        int[] ints = Arrays.stream(digitArr).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum+=Math.pow(ints[i], p++);
        }
        return (double)sum / n % 1 == 0 ? (long) ((double)sum / n) : -1l;
    }
}
