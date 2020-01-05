package exercises;

import java.util.BitSet;
import java.util.stream.IntStream;

public class Primes {
    private static final int MAX = 820_000_000;
    private static final int SQRT = (int) Math.sqrt(MAX);
    private static BitSet sieve;

    static {
        sieve = new BitSet(MAX);
        sieve.set(2, MAX + 1);
        int primeCandidateIndex = 1;
        while (primeCandidateIndex <= SQRT) {
            primeCandidateIndex = sieve.nextSetBit(primeCandidateIndex + 1);
            for (int notPrimeIndex = primeCandidateIndex * primeCandidateIndex; notPrimeIndex <= MAX; notPrimeIndex += primeCandidateIndex) {
                sieve.clear(notPrimeIndex);
            }
        }
    }

    public static IntStream stream() {
        return IntStream.iterate(2, number -> sieve.nextSetBit(number + 1));
    }
}