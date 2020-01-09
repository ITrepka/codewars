package exercises;

import java.util.Arrays;

public class SortOdd {
    public static int[] sortArray(int[] array) {
        int[] sortedOdds = Arrays.stream(array).filter(number -> number % 2 == 1).sorted().toArray();
        int intsIndex = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] % 2 == 1 ? sortedOdds[intsIndex++] : array[i];
        }
        return array;
    }
}
