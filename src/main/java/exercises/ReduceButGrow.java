package exercises;

import java.util.Arrays;

public class ReduceButGrow {
    public static int grow(int[] ints) {
        return Arrays.stream(ints).reduce(1, (subtotal, element) -> subtotal * element);
    }
}
