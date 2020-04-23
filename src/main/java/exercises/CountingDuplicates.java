package exercises;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
        int result = 0;
        for (char j = 'a'; j <='z' ; j++) {
            int counter = 0;
            for (int i = 0; i < text.length(); i++) {
                if (String.valueOf(j).equalsIgnoreCase(String.valueOf(text.charAt(i)))){
                    counter++;
                }
            }
            if (counter > 1) {
                result++;
            }
        }
        return result;
    }
}
