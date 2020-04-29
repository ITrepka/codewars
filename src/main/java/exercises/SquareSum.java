package exercises;

import java.util.Arrays;

public class SquareSum {
    public static int squareSum(int[] n)
    {
        return Arrays.stream(n).map(e -> e * e).sum();
    }
}
