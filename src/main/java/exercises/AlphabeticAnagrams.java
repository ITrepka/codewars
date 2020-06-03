package exercises;

import java.math.BigInteger;
import java.util.*;

//the algorithm was developed based on the video: https://www.youtube.com/watch?v=9QzKqSvbMYM

public class AlphabeticAnagrams {
    public static BigInteger listPosition(String word) {
        Map<Character, Integer> letterRank = checkLetterRanks(word);
        List<Integer> listOfLetterRanksInWordOrder = changeWordToListLettersRank(word, letterRank);
        return calculateRankOfWord(listOfLetterRanksInWordOrder);
    }

    private static BigInteger calculateRankOfWord(List<Integer> listOfLetterRanksInWordOrder) {
        List<Integer> numbersOfLowerNumbersOnTheRightSite = new ArrayList<>();
        List<List<Integer>> numberOfLowerPositionWithCopies = new ArrayList<>();

        fillLists(listOfLetterRanksInWordOrder, numbersOfLowerNumbersOnTheRightSite, numberOfLowerPositionWithCopies);

        BigInteger result = BigInteger.ZERO;
        result = calculateResult(listOfLetterRanksInWordOrder, numbersOfLowerNumbersOnTheRightSite, numberOfLowerPositionWithCopies, result);

        return result.add(BigInteger.ONE);
    }

    private static BigInteger calculateResult(List<Integer> listOfLetterRanksInWordOrder, List<Integer> numbersOfLowerNumbersOnTheRightSite, List<List<Integer>> numberOfLowerPositionWithCopies, BigInteger result) {
        for (int i = 0; i < listOfLetterRanksInWordOrder.size(); i++) {
            BigInteger divider = BigInteger.valueOf(numbersOfLowerNumbersOnTheRightSite.get(i));
            divider = divider.multiply(calculateFactorial(listOfLetterRanksInWordOrder.size() - i - 1));
            BigInteger dividend = calculateDivider(numberOfLowerPositionWithCopies.get(i));
            BigInteger quotient = divider.divide(dividend);
            result = result.add(quotient);
        }
        return result;
    }

    private static void fillLists(List<Integer> listOfLetterRanksInWordOrder, List<Integer> numbersOfLowerNumbersOnTheRightSite, List<List<Integer>> numberOfLowerPositionWithCopies) {
        for (int i = 0; i < listOfLetterRanksInWordOrder.size(); i++) {
            numbersOfLowerNumbersOnTheRightSite.add(checkNumberOfLowerNumbersOnTheRightSite(i, listOfLetterRanksInWordOrder));
            numberOfLowerPositionWithCopies.add(findNumberOfLowerPositionWithCopies(i, listOfLetterRanksInWordOrder));
        }
    }

    private static BigInteger calculateDivider(List<Integer> integers) {
        BigInteger result = BigInteger.ONE;

        for (Integer integer : integers) {
            result = result.multiply(calculateFactorial(integer));
        }
        return result;
    }

    private static List<Integer> findNumberOfLowerPositionWithCopies(int i, List<Integer> listOfLetterRanksInWordOrder) {
        List<Integer> list = new ArrayList<>();
        List<Integer> checkedNumbers = new ArrayList<>();
        for (int j = i; j < listOfLetterRanksInWordOrder.size(); j++) {
            if (!checkedNumbers.contains(listOfLetterRanksInWordOrder.get(j))){
                list.add(findNumberOfLowerNumbersCopies(j, listOfLetterRanksInWordOrder));
                checkedNumbers.add(listOfLetterRanksInWordOrder.get(j));
            }
        }
        return list;
    }

    private static Integer findNumberOfLowerNumbersCopies(int j, List<Integer> listOfLetterRanksInWordOrder) {
        int counter = 0;
        for (int i = j; i < listOfLetterRanksInWordOrder.size(); i++) {
            if (listOfLetterRanksInWordOrder.get(i) == listOfLetterRanksInWordOrder.get(j)) {
                counter++;
            }
        }
        return counter;
    }

    private static Integer checkNumberOfLowerNumbersOnTheRightSite(int i, List<Integer> listOfLetterRanksInWordOrder) {
        int counter = 0;
        for (int j = i + 1; j < listOfLetterRanksInWordOrder.size(); j++) {
            if (listOfLetterRanksInWordOrder.get(j) < listOfLetterRanksInWordOrder.get(i)) {
                counter++;
            }
        }
        return counter;
    }

    private static List<Integer> changeWordToListLettersRank(String word, Map<Character, Integer> letterRank) {
        List<Integer> listOfLetterRanksInWordOrder = new ArrayList<>();

        for (char letter : word.toCharArray()) {
            Integer position = letterRank.get(letter);
            listOfLetterRanksInWordOrder.add(position);
        }

        return listOfLetterRanksInWordOrder;
    }

    private static Map<Character, Integer> checkLetterRanks(String word) {
        Map<Character, Integer> letterRank = new HashMap<>();
        for (Character letter: word.toCharArray()) {
            letterRank.put(letter, 1);
        }

        SortedSet<Character> keys = new TreeSet<>(letterRank.keySet());
        letterRank = new HashMap<>();
        int position = 1;
        for (Character key : keys) {
            letterRank.put(key, position++);
        }

        return letterRank;
    }

    private static BigInteger calculateFactorial(int limit) {
        // Initialize result
        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE

        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= limit; i++)
            f = f.multiply(BigInteger.valueOf(i));

        return f;
    }
}
