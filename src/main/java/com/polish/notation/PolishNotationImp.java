package com.polish.notation;

import java.util.Deque;
import java.util.LinkedList;

public class PolishNotationImp {

    public double evaluateExpression(String equation) {
        ExpressionWrapper expressionWrapper = new ExpressionWrapper(equation);
        Deque<Double> stack = new LinkedList<>();
        for (String element : expressionWrapper) {
            if (isNumeric(element)) {
                stack.offerLast(Double.parseDouble(element));
            } else {
                double secondNumber = stack.pollLast();
                Double firstNumber = stack.pollLast();
                stack.offerLast(MathOperation.of(element).evaluate(firstNumber, secondNumber));
            }
        }
        return stack.pop();
    }

    private static boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
