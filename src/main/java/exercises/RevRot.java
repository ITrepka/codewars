package exercises;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class RevRot {
    public static String revRot(String strng, int sz) {
        if (sz <= 0 || strng.isEmpty()) return "";

        LinkedList<String> chunks = new LinkedList<>();

        for (int i = 0; i < strng.length(); i += sz) {
            if (i + sz <= strng.length()) {
                chunks.add(strng.substring(i, i + sz));
            }
        }
        return chunks.stream()
                .map(chunk -> calculateSum(chunk) % 2 == 0 ? rev(chunk) : rot(chunk))
                .collect(Collectors.joining());
    }

    private static String rev(String chunk) {
        return new StringBuilder(chunk).reverse().toString();
    }

    private static String rot(String chunk) {
        return chunk.substring(1) + chunk.substring(0, 1);
    }

    private static int calculateSum(String chunk) {
        int sum = 0;
        for (String digit : chunk.split("")) {
            sum += Integer.parseInt(digit);
        }
        return sum;
    }
}
