package exercises;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class HighestScoringWord {
    public static String high(String s) {
        IntPredicate letterPredicate = letter -> letter >= 'a' || letter <= 'z';
        return Arrays.stream(s.split(" "))
                .sorted((word1, word2) -> getWordScore(letterPredicate, word2) - getWordScore(letterPredicate, word1))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private static int getWordScore(IntPredicate letterPredicate, String word2) {
        return word2.chars().filter(letterPredicate).sum() - (int) word2.chars().filter(letterPredicate).count() * ('a' - 1);
    }
}
