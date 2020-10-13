package exercises;

import java.util.Arrays;

public class TwoToOne {
    public static String longest (String s1, String s2) {
        int[] chars = new StringBuilder(s1).append(s2).chars().distinct().sorted().toArray();
        StringBuilder result = new StringBuilder();
        Arrays.stream(chars).forEach(ch -> result.append((char) ch));
        return result.toString();
    }
}
