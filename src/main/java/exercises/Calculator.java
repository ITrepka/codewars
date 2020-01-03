package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private static Pattern numberPattern = Pattern.compile("(-?[0-9]+)\\.?([0-9]?)*");
    private static Pattern operatorPattern = Pattern.compile("^[*+\\-/^]");

    public static double evaluate(String expression) {
        return countResult(expression);
    }

    private static Double countResult(String equation) {
        String rpn = convertToRpn(equation);
        Double result = evaluateRPN(rpn);
        return result;
    }

    public static double evaluateRPN(String rpn) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = rpn.split(" ");
        String token;
        System.out.println(Arrays.toString(tokens));
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            if (isDouble(token)) {
                stack.push(Double.valueOf(token));
            } else {
                double a = stack.pop();
                double b = stack.pop();
                double res = evaluateOperation(token, b, a);
                stack.push(res);
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String string) {
        return operatorPattern.matcher(string).matches();
    }

    private static boolean isDouble(String string) {
        return numberPattern.matcher(string).matches();
    }

    private static double evaluateOperation(String operation, double a, double b) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("Unsuported operation: " + operation);
        }
    }

    private static int priority(String token) {
        switch (token) {
            case "(":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                throw new RuntimeException("probably bad operator pattern");
        }
    }

    private static String convertToRpn(String equation) { //"3 + 2 * 5"
        Stack<String> stack = new Stack();
        StringBuilder output = new StringBuilder();
        String[] tokens = equation.split(" ");
        List<String> tokensList = Arrays.stream(tokens)
                .map(token -> token.trim())
                .filter(token -> token.length() > 0)
                .collect(Collectors.toList());
        for (int i = 0; i < tokensList.size(); i++) {
            String token = tokensList.get(i);
            if (token.equals("(")) { //step 8
                stack.push(token);
                continue;
            } else if (token.equals(")")) { // step11
                String operator;
                while (!stack.peek().equals("(")) {
                    operator = stack.pop();
                    output.append(operator + " ");
                }
                stack.pop();
                continue;
            } else if (isOperator(token)) { //step17
                while (!stack.isEmpty() && priority(token) <= priority(stack.peek())) {
                    String operator;
                    operator = stack.pop();
                    output.append(operator + " ");
                }
                stack.push(token);
                continue;
            } else {
                output.append(token + " ");
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop() + " ");
        }

        return output.toString();
    }
}