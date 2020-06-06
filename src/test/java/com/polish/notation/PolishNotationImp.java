package com.polish.notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PolishNotationImpTest {

    PolishNotationImp polishNotation = new PolishNotationImp();

    @Test
    public void shouldReturnGivenNumber() {
        String equation = "5";

        Assertions.assertEquals(5D, polishNotation.evaluateExpression(equation));
    }

    @Test
    public void shouldSumTwoNumbers() {
        String equation = "11 12.5 +";

        Assertions.assertEquals(23.5D, polishNotation.evaluateExpression(equation));
    }

    @Test
    public void shouldSubtractTwoNumbers() {
        String equation = "11 12 -";

        Assertions.assertEquals(-1, polishNotation.evaluateExpression(equation));
    }

    @Test
    public void shouldMultiplyTwoNumbers() {
        String equation = "2 5.5 *";

        Assertions.assertEquals(11, polishNotation.evaluateExpression(equation));
    }

    @Test
    public void shouldDivideTwoNumbers() {
        String equation = "5 2 /";

        Assertions.assertEquals(2.5, polishNotation.evaluateExpression(equation));
    }

    @Test
    public void shouldEvaluateMixedExpression() {
        String equation = "12 2 3 4 * 10 5 / + * +";

        Assertions.assertEquals(40, polishNotation.evaluateExpression(equation));
    }

    @Test
    public void shouldThrowExceptionWhenWrongExpression() {
        String equation = "abc";

        Assertions.assertThrows(IllegalArgumentException.class, () -> polishNotation.evaluateExpression(equation));
    }

}
