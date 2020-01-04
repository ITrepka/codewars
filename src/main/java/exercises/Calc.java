package exercises;

import java.util.Stack;
import java.util.regex.Pattern;

public class Calc {
    private static Pattern operatorPattern = Pattern.compile("^[*+\\-/]");

    public double evaluate(String expr) {
        if (expr.isEmpty()) {
            return 0;
        }

        Stack<Double> stack = new Stack<>();
        String[] tokens = expr.split(" ");
        for (String token : tokens) {
            if (operatorPattern.matcher(token).matches()) {
                double a = stack.pop();
                double b = stack.pop();
                double res = evaluateOperation(token, b, a);
                stack.push(res);
            } else {
                stack.push(Double.valueOf(token));
            }
        }
        return stack.pop();
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
}
