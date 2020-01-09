package exercises;

public class DivisibleCount {
    public static long divisibleCount(int x, int y, int k) {
        long counter = (y / k) - (x / k);
        return x % k == 0 ? counter + 1 : counter;
    }
}
