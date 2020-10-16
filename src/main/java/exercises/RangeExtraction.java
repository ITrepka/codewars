package exercises;

import java.util.ArrayList;
import java.util.List;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder();
        boolean consecutive;
        int consecutiveNumber = 1;
        List<List<Integer>> elementsToWrite = new ArrayList<>();
        int previous = arr[0];
        List<Integer> innerList = new ArrayList<>();
        innerList.add(previous);

        for (int i = 1; i < arr.length; i++) {
            consecutive = arr[i] - 1 == previous;
            if (!consecutive && consecutiveNumber > 2) {
                elementsToWrite.add(innerList);
                innerList = new ArrayList<>();
                innerList.add(arr[i]);
                consecutiveNumber = 1;
                if (i == arr.length - 1) {
                    elementsToWrite.add(innerList);
                }
            } else if (!consecutive && consecutiveNumber <= 2) {
                List<Integer> tempInnerList = new ArrayList<>(innerList);
                for (Integer integer : tempInnerList) {
                    innerList = new ArrayList<>();
                    innerList.add(integer);
                    elementsToWrite.add(innerList);
                }
                innerList = new ArrayList<>();
                innerList.add(arr[i]);
                consecutiveNumber = 1;
                if (i == arr.length - 1) {
                    elementsToWrite.add(innerList);
                }
            } else if (i == arr.length - 1 && consecutiveNumber == 1) {
                innerList.add(arr[i]);
                List<Integer> tempInnerList = new ArrayList<>(innerList);
                for (Integer integer : tempInnerList) {
                    innerList = new ArrayList<>();
                    innerList.add(integer);
                    elementsToWrite.add(innerList);
                }
            } else {
                innerList.add(arr[i]);
                consecutiveNumber++;
                if (i == arr.length - 1) {
                    elementsToWrite.add(innerList);
                }
            }

            previous = arr[i];
        }

        for (List<Integer> list : elementsToWrite) {
            if (list.size() == 1) {
                result.append(list.get(0));
                result.append(",");
            } else {
                result.append(list.get(0));
                result.append("-");
                result.append(list.get(list.size() - 1));
                result.append(",");
            }
        }

        System.out.println(result.toString());
        return result.toString().substring(0, result.toString().length() - 1);
    }
}
