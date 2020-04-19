package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class DifferenceOf2 {
    public static int[][] twosDifference(int[] array) {
        Set<int[]> resultSet = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (Math.abs(array[i] - array[j]) == 2) {
                    resultSet.add(new int[]{Math.min(array[i],array[j]), Math.max(array[i], array[j])});
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(resultSet);
        resultList = resultList.stream().sorted((e1, e2) -> e2[0] - e1[0]).collect(Collectors.toList());
        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        System.out.println(Arrays.deepToString(result));;
        return result;
    }
}
