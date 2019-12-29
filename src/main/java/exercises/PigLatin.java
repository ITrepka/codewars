package exercises;

import java.util.regex.Pattern;

public class PigLatin {
    public static String pigIt(String str) {
//        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
        String[] split = str.split("");
        String regex = "[A-Za-z0-9]+";

        StringBuilder sb = new StringBuilder();
        String firstLetter = null;
        for (int i = 0; i < split.length; i++) {
            if (firstLetter == null) {
                if (Pattern.matches(regex, split[i])) {
                    firstLetter = split[i];
                } else {
                    sb.append(split[i]);
                }
            }else {
                if (Pattern.matches(regex, split[i])) {
                    sb.append(split[i]);
                }else if (!Pattern.matches(regex, split[i])){
                    sb.append(firstLetter + "ay" + split[i]);
                    firstLetter = null;
                }
            }
        }

        if (firstLetter != null) {
            sb.append(firstLetter + "ay");
        }

        return sb.toString();
    }
}
