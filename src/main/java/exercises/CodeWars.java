package exercises;

public class CodeWars {
    public static int strCount(String str, char letter) {
        return (int) str.chars().filter(ch -> ch == letter).count();
    }
}
