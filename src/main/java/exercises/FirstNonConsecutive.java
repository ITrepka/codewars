package exercises;

public class FirstNonConsecutive {
    public static Integer find(final int[] array) {
        Integer res = null;
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != temp + 1){
                res = array[i];
                break;
            }
            temp = array[i];
        }
        return res;
    }
}
