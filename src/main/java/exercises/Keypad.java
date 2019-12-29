package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Keypad {
    public static final Map<Integer, List<String>> keypad = new HashMap<>();
    static {
        keypad.put(1, Arrays.asList("1", "A", "D", "G", "J", "M", "P", "T", "W", "*", " ", "#"));
        keypad.put(2, Arrays.asList("0", "B", "E", "H", "K", "N", "Q", "U", "X"));
        keypad.put(3, Arrays.asList("C", "F", "I", "L", "O", "R", "V", "Y"));
        keypad.put(4, Arrays.asList("2", "3", "4", "5", "6", "8", "S", "Z"));
        keypad.put(5, Arrays.asList("7", "9"));
    }

    public static int presses(String phrase) {
        String[] letters = phrase.split("");
        final int[] numberOfTaps = {0};

        Arrays.stream(letters).forEach(letter -> {
                    Integer tapsToSingleChar = keypad.entrySet().stream()
                            .filter(entry -> entry.getValue().contains(letter.toUpperCase()) || entry.getValue().contains(letter.toLowerCase()))//po wszystkich
                            .map(Map.Entry::getKey)
                            .findFirst()
                            .orElse(null);
                    if (tapsToSingleChar != null) {
                        numberOfTaps[0] += tapsToSingleChar;
                    }
                }
        );

        return numberOfTaps[0];
    }
}
