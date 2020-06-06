package com.polish.notation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MathOperation {

    PLUS("+", BigDecimal::add),
    MINUS("-", BigDecimal::subtract),
    MULTIPLY("*", BigDecimal::multiply),
    DIVIDE("/", BigDecimal::divide);

    private String operation;
    private BinaryOperator<BigDecimal> mathEvaluator;

    private static Map<String, List<MathOperation>> mathOperationMap = Stream.of(MathOperation.values())
            .collect(Collectors.groupingBy(MathOperation::mathOperation));

    public static MathOperation of(String operation) {
        if (!mathOperationMap.containsKey(operation)) {
            throw new IllegalArgumentException(operation + " not allowed");
        }
        return mathOperationMap.get(operation).get(0);
    }

    MathOperation(String operation, BinaryOperator<BigDecimal> mathEvaluator) {
        this.operation = operation;
        this.mathEvaluator = mathEvaluator;
    }

    public BigDecimal evaluate(BigDecimal number1, BigDecimal number2) {
        return mathEvaluator.apply(number1, number2);
    }

    public String mathOperation() {
        return operation;
    }


}
