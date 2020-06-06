package com.polish.notation;

import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MathOperation {

    PLUS("+", Double::sum),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> number1 / number2);

    private String operation;
    private ToDoubleBiFunction<Double, Double> mathEvaluator;

    private static Map<String, List<MathOperation>> mathOperationMap = Stream.of(MathOperation.values())
            .collect(Collectors.groupingBy(MathOperation::mathOperation));

    public static MathOperation of(String operation) {
        if (!mathOperationMap.containsKey(operation)) {
            throw new IllegalArgumentException(operation + " not allowed");
        }
        return mathOperationMap.get(operation).get(0);
    }

    MathOperation(String operation, ToDoubleBiFunction<Double, Double> mathEvaluator) {
        this.operation = operation;
        this.mathEvaluator = mathEvaluator;
    }

    public double evaluate(double number1, double number2) {
        return mathEvaluator.applyAsDouble(number1, number2);
    }

    public String mathOperation() {
        return operation;
    }


}
