package exercises;

//Write code to determine the missing digit or unknown runeValue
//Expression will always be in the form
//(number)[opperator](number)=(number)
//Unknown digit will not be the same as any other digits used in expression

public class Runes {
    public static int solveExpression(final String expression) {
        String operator = findOperator(expression);
        String firstNumber = findFirstNumber(expression, operator);
        String secondNumber = findSecondNumber(expression, operator);
        String result = findResult(expression, operator);

        Integer runeValue;
        try {
            runeValue = findRune(operator, firstNumber, secondNumber, result);
        } catch (Exception e) {
            System.out.println("Unknown operator");
            runeValue = null;
        }

        return runeValue;
    }

    private static int findRune(String operator, String firstNumber, String secondNumber, String result) throws Exception {
        for (int i = 0; i < 10; i++) {
            boolean isNeededIterationSkipping = checkIfIterationSkippingIsNeeded(i, firstNumber, secondNumber, result);

            if (isNeededIterationSkipping){
                continue;
            }

            String firstNumberWithoutRunes = firstNumber.replaceAll("\\?", String.valueOf(i));
            String secondNumberWithoutRunes = secondNumber.replaceAll("\\?", String.valueOf(i));
            String resultWithoutRunes = result.replaceAll("\\?", String.valueOf(i));

            int firstNumberAsNumber = Integer.parseInt(firstNumberWithoutRunes);
            int secondNumberAsNumber = Integer.parseInt(secondNumberWithoutRunes);
            int resultAsNumber = Integer.parseInt(resultWithoutRunes);

            if (makeOperation(firstNumberAsNumber, secondNumberAsNumber, operator) == resultAsNumber) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkIfIterationSkippingIsNeeded(int i, String firstNumber, String secondNumber, String result) {
        //checking is actual "i" appears in expression
        if (firstNumber.contains(String.valueOf(i)) || secondNumber.contains(String.valueOf(i)) || result.contains(String.valueOf(i))) {
            return true;
        }
        //zero cannot be the first digit in any element
        if (i == 0) {
            if (firstNumber.replaceAll("-", "").charAt(0) == '?' && firstNumber.replaceAll("-", "").length() > 1) {
                return true;
            }
            if (secondNumber.replaceAll("-", "").charAt(0) == '?' && secondNumber.replaceAll("-", "").length() > 1) {
                return true;
            }
            if (result.replaceAll("-", "").charAt(0) == '?' && result.replaceAll("-", "").length() > 1) {
                return true;
            }
        }
        return false;
    }

    private static int makeOperation(int firstNumberAsNumber, int secondNumberAsNumber, String operator) throws Exception {
        switch (operator) {
            case "*":
                return firstNumberAsNumber * secondNumberAsNumber;
            case "+":
                return firstNumberAsNumber + secondNumberAsNumber;
            case "-":
                return firstNumberAsNumber - secondNumberAsNumber;
            default:
                throw new Exception("Something wrong happened");
        }
    }

    private static String findResult(String expression, String operator) {
        String result;

        if (operator.equals("+")) {
            result = expression.split("\\+")[1].split("=")[1];
        } else if (operator.equals("*")) {
            result = expression.split("\\*")[1].split("=")[1];
        } else if (expression.contains("--")) {
            result = expression.split("--")[1].split("=")[1];
        } else {
            result = expression.split("-")[1].split("=")[1];
        }

        return result;
    }

    private static String findSecondNumber(String expression, String operator) {
        String secondNumber;

        if (operator.equals("+")) {
            secondNumber = expression.split("\\+")[1].split("=")[0];
        } else if (operator.equals("*")) {
            secondNumber = expression.split("\\*")[1].split("=")[0];
        } else if (expression.contains("--")) {
            secondNumber = "-" + expression.split("--")[1].split("=")[0];
        } else {
            secondNumber = expression.split("-")[1].split("=")[0];
        }

        return secondNumber;
    }

    private static String findFirstNumber(String expression, String operator) {
        String firstNumber;

        if (operator.equals("+")) {
            firstNumber = expression.split("\\+")[0];
        } else if (operator.equals("*")) {
            firstNumber = expression.split("\\*")[0];
        } else if (expression.charAt(0) == '-') {
            firstNumber = "-" + expression.substring(1).split("-")[0];
        } else {
            firstNumber = expression.split("-")[0];
        }

        return firstNumber;
    }

    private static String findOperator(String expression) {
        String operator;
        if (expression.contains("+")) {
            operator = "+";
        } else if (expression.contains("*")) {
            operator = "*";
        } else {
            operator = "-";
        }
        return operator;
    }
}
