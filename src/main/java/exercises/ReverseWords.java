package exercises;

public class ReverseWords {
    public static String reverseWords(final String original) {
        if (original.replaceAll(" ", "").length() == 0) {
            return original;
        }
        String[] arr = original.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            result.append(sb.reverse());
            if (i < arr.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
