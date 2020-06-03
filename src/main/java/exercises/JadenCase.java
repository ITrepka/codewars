package exercises;

public class JadenCase {
    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] words = phrase.split(" ");
        for (String word: words) {
            sb.append(firstLetterUp(word));
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    public String firstLetterUp(String word) {
        StringBuilder sb = new StringBuilder();
        String[] arr = word.split("");
        arr[0] = arr[0].toUpperCase();
        for (String letter : arr) {
            sb.append(letter);
        }
        return sb.toString();
    }
}
