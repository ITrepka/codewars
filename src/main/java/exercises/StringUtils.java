package exercises;

public class StringUtils {
    public static String toAlternativeString(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (isLowCase(string.charAt(i))) {
                result.append(String.valueOf(string.charAt(i)).toUpperCase());
            }else if (isUpCase(string.charAt(i))){
                result.append(String.valueOf(string.charAt(i)).toLowerCase());
            }else {
                result.append(string.charAt(i));
            }
        }

        return result.toString();
    }

    private static boolean isUpCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private static boolean isLowCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
