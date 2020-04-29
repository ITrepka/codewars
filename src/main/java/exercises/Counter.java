package exercises;

import java.util.Arrays;

public class Counter {
    public int countSheeps(Boolean[] arrayOfSheeps) {
        return arrayOfSheeps == null ? 0 :(int) Arrays.stream(arrayOfSheeps).filter(e -> e != null && e.equals(Boolean.TRUE)).count();
    }
}
