package com.polish.notation;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class PolishNotationImp {

    public BigDecimal evaluateExpression(String equation) {
        ExpressionWrapper expressionWrapper = new ExpressionWrapper(equation);
        Deque<BigDecimal> stack = new LinkedList<>();
        for (String element : expressionWrapper) {
            if (isNumeric(element)) {
                stack.offerLast(new BigDecimal(element));
            } else {
                BigDecimal secondNumber = stack.pollLast();
                BigDecimal firstNumber = stack.pollLast();
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
