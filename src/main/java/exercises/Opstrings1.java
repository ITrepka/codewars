package exercises;

import java.util.function.Function;

public class Opstrings1 {

    public static String rot(String strng) {
        StringBuilder sb = new StringBuilder(strng);
        return sb.reverse().toString();
    }
    public static String selfieAndRot(String strng) {
        int numberOfDots = strng.indexOf("\n");
        String dots = "";
        for (int i = 0 ; i < numberOfDots ; i++){
            dots += ".";
        }
        String addedDots = strng.replaceAll("\n", dots+"\n");
        addedDots += dots;
        return addedDots + "\n" + rot(addedDots);
    }
    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }
}