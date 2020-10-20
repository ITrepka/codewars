package exercises;

public class DRoot {
    public static int digital_root(int n) {
        while(n > 9) {
            int temp = 0;
            for (String s : String.valueOf(n).split("")) {
                temp += Integer.parseInt(s);
            }
            n = temp;
        }
        return n;
    }
}
