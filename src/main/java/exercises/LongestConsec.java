package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length == 0 || k > strarr.length || k <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        List<Integer> numberOfLettersInSequence = new ArrayList<>();
        int max = 0;

        for (int i = 0; i <= strarr.length - k; i++) {
            int numberOfLetters = 0;
            for (int j = i; j < i + k; j++) {
                numberOfLetters += strarr[j].length();
            }
            numberOfLettersInSequence.add(numberOfLetters);

            if (numberOfLetters > max) {
                max = numberOfLetters;
            }
        }

        int firstElementIndex = numberOfLettersInSequence.indexOf(max);

        for (int i = firstElementIndex; i < firstElementIndex + k; i++) {
            result.append(strarr[i]);
        }

        return result.toString();
    }
}
