package com.polish.notation;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class PolishNotationImp {

    public BigDecimal evaluateExpression(String equation) {
        ExpressionWrapper expressionWrapper = new ExpressionWrapper(equation);
        Deque<BigDecimal> stack = new LinkedList<>();
        for (String element : expressionWrapper) {
            if (MathOperation.isMathOperator(element)) {
                BigDecimal secondNumber = stack.pollLast();
                BigDecimal firstNumber = stack.pollLast();
                stack.offerLast(MathOperation.of(element).evaluate(firstNumber, secondNumber));
            }
            else {
                stack.offerLast(new BigDecimal(element));
            }
        }
        return stack.pop();
    }
}
