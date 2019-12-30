package exercises;

import java.util.Scanner;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        Scanner scanner = new Scanner(text);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();

            boolean commentedPart = false;

            for (String commentSymbol : commentSymbols) {
                if (line.contains(commentSymbol)) {
                    int index = line.indexOf(commentSymbol);
                    sb.append(line.substring(0, index));
                    commentedPart = true;
                    break;
                }
            }
            if (!commentedPart) {
                sb.append(line);
            }
            while (sb.toString().endsWith(" ")){
                sb.deleteCharAt(sb.toString().length() - 1);
            }
            sb.append("\n");
        }

        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
