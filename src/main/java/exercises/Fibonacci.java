package exercises;

import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fib(BigInteger n) {
        if (n.intValue() == 0) {
            return BigInteger.valueOf(0);
        }
        boolean isNegative = n.intValue() < 0;
        boolean isEven = n.intValue() % 2 == 0;
        if (isNegative) {
            n = n.multiply(BigInteger.valueOf(-1));
        }

        BigInteger f[] = new BigInteger[3];

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = BigInteger.valueOf(0);
        f[1] = BigInteger.valueOf(1);
        f[2] = BigInteger.valueOf(1);
        for (int i = 3; i <= n.intValue(); i++)
        {
       /* Add the previous 2 numbers in the series
        and store it */
            f[0] = f[1];
            f[1] = f[2];
            f[2] = f[0].add(f[1]);
        }
        System.out.println(f[2].intValue());
        return isNegative && isEven ? f[2].multiply(BigInteger.valueOf(-1)) : f[2];
    }

}
