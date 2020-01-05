package exercises;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {
    private static Pattern numberPattern = Pattern.compile("(-?[0-9]+)\\.?([0-9]?)*");

    public static double evaluate(String expression) {
        return calculate(expression);
    }

    private static Double calculate(String equation) {
        List<String> rpn = convertToRpn(equation);
        return evaluateRPN(rpn);
    }

    private static double evaluateRPN(List<String> rpn) {
        Stack<Double> stack = new Stack<>();
        for (String token : rpn) {
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

    private static List<String> convertToRpn(String equation) {
        Map<String, Integer> operatorsPriority = new HashMap<>();
        operatorsPriority.put("(", 0);
        operatorsPriority.put("+", 1);
        operatorsPriority.put("-", 1);
        operatorsPriority.put("*", 2);
        operatorsPriority.put("/", 2);

        Stack<String> stack = new Stack();
        List<String> output = new LinkedList<>();
        String[] tokens = equation.split(" ");
        for (String token : tokens) {
            if (token.equals("(")) { //step 8
                stack.push(token);
                continue;
            }
            if (token.equals(")")) { // step11
                String operator;
                while (!stack.peek().equals("(")) {
                    operator = stack.pop();
                    output.add(operator);
                }
                stack.pop();
                continue;
            }
            if (operatorsPriority.containsKey(token)) { //step17
                while (!stack.isEmpty() && operatorsPriority.get(token) <= operatorsPriority.get(stack.peek())) {
                    String operator;
                    operator = stack.pop();
                    output.add(operator);
                }
                stack.push(token);
                continue;
            }

            if (isDouble(token)) {
                output.add(token);
                continue;
            }

            throw new IllegalArgumentException("Invalid inpuuuut");
        }
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }
}