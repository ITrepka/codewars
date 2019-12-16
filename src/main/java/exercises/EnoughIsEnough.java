package exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        return IntStream.of(elements)
                .filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
                .toArray();
        //        List<Integer> list = new ArrayList<>();
//        for (int element : elements) {
//            if (howManyElementInList(element, list) < maxOccurrences) {
//                list.add(element);
//            }
//        }
//        return list.stream().mapToInt(value -> value).toArray();
    }

    private static int howManyElementInList(int element, List<Integer> list) {
        int result = 0;
        for (Integer number : list) {
            if (number == element) {
                result++;
            }
        }
        return result;
    }
}
