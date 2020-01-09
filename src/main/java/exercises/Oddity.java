package exercises;

import java.math.BigInteger;

public class Oddity {
    public static String oddity(BigInteger n) {
        long longN = n.longValue();
        return Math.sqrt(longN) == (long) Math.sqrt(longN) ? "odd" : "even";
    }
}
