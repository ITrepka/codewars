package exercises;

import java.util.ArrayList;
import java.util.List;

public class BlackOrWhiteKey {
    public static String blackOrWhiteKey(int keyPressCount) {
        List<String> keys = new ArrayList<>();
        keys.add("white");
        keys.add("black");
        keys.add("white");
        keys.add("white");
        for (int i = 0; i < 7; i++) {
            keys.add("black");
            keys.add("white");
            keys.add("black");
            keys.add("white");
            keys.add("white");
            keys.add("black");
            keys.add("white");
            keys.add("black");
            keys.add("white");
            keys.add("black");
            keys.add("white");
            keys.add("white");
        }
        int numberOfParts = keyPressCount / keys.size();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < numberOfParts + 1; i++) {
            board.addAll(keys);
        }
        return board.get(keyPressCount - 1);
    }
}
