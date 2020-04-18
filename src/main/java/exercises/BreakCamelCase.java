package exercises;

public class BreakCamelCase {
    public static String camelCase(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                sb.append(" ");
                sb.append(input.charAt(i));
            }else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
