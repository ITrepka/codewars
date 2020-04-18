package exercises;

import java.util.ArrayList;
import java.util.List;

public class PointsInSegments {
    public static int[] segments(final int m, final int[][] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= m ; i++) {
            list.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            deleteSegmentFromList(list, arr[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void deleteSegmentFromList(List<Integer> list, int[] ints) {
        list.removeIf(i -> i >= ints[0] && i <= ints[ints.length-1]);
    }
}
