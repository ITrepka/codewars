package exercises;

import java.util.ArrayList;
import java.util.List;

public class FindOdd {
    public static int findIt(int[] a) {
        List<Integer> crossedNumbers = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int appearsNumber = 1;
            if (!crossedNumbers.contains(a[i])){
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]) {
                        appearsNumber++;
                    }
                }
                if (appearsNumber % 2 == 1) {
                    return a[i];
                }
            }
            crossedNumbers.add(a[i]);
        }
        throw new RuntimeException("Something wrong happened");
    }
}
