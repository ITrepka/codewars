package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class ObservedPin {
    private static final Map<String, List<String>> pinMap = new HashMap<>();

    static {
        pinMap.put("1", Arrays.asList("1", "2", "4"));
        pinMap.put("2", Arrays.asList("1", "2", "3", "5"));
        pinMap.put("3", Arrays.asList("2", "3", "6"));
        pinMap.put("4", Arrays.asList("1", "4", "5", "7"));
        pinMap.put("5", Arrays.asList("2", "4", "5", "6", "8"));
        pinMap.put("6", Arrays.asList("3", "5", "6", "9"));
        pinMap.put("7", Arrays.asList("4", "7", "8"));
        pinMap.put("8", Arrays.asList("5", "7", "8", "9", "0"));
        pinMap.put("9", Arrays.asList("6", "8", "9"));
        pinMap.put("0", Arrays.asList("8", "0"));
    }

    public static List<String> getPINs(String entered) {
        String[] enteredArr = entered.split("");
        List<List<String>> optionalNumbersLists = new ArrayList<>();
        for (String enteredElement : enteredArr) {
            List<String> numbers = pinMap.entrySet().stream()
                    .filter(entered2 -> entered2.getKey().equals(enteredElement))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(null);
            optionalNumbersLists.add(numbers);
        }

        List<StringBuilder> sb = new ArrayList<>();
        for (String ignored : optionalNumbersLists.get(0)) {
            sb.add(new StringBuilder());
        }

        List<StringBuilder> sb2 = new ArrayList<>();

        for (List<String> optionalNumbersList : optionalNumbersLists) {
            for (StringBuilder stringBuilder : sb) {
                for (String optionalNumber : optionalNumbersList) {
                    sb2.add(new StringBuilder(stringBuilder.toString() + optionalNumber));
                }
            }
            sb = new ArrayList<>(sb2);
        }

        return sb.stream()
                .map(StringBuilder::toString)
                .filter(pin -> pin.length() == entered.length())
                .distinct()
                .collect(Collectors.toList());
    }
}
