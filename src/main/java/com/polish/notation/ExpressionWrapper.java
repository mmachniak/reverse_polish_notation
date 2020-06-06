package com.polish.notation;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ExpressionWrapper implements Iterable<String> {

    private String orginalExpression;
    private List<String> expressionElements;

    ExpressionWrapper(String expression) {
        this.orginalExpression = expression;
        parseStringExpression();
    }

    private void parseStringExpression() {
        if (orginalExpression == null || orginalExpression.isEmpty()) {
            throwIllegalArgumentException();
        }
        String[] elements = orginalExpression.split(" ");
        expressionElements = Stream.of(elements).filter(s -> !s.isEmpty()).peek(this::validateElement).collect(Collectors.toList());
    }

    private void validateElement(String element) {
        if (!isNumeric(element) && !MathOperation.isMathOperator(element)) {
            throwIllegalArgumentException();
        }
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException(this + " cannot be evaluated");
    }

    private boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return orginalExpression;
    }

    @Override
    public Iterator<String> iterator() {
        return expressionElements.iterator();
    }
}
