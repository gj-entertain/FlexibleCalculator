package com.example;

import java.util.Map;

public class Calculator {

    private final Map<Operation, OperationStrategy> operationMap;

    // Constructor that accepts a map of operations, enabling dependency injection
    public Calculator(Map<Operation, OperationStrategy> operationMap) {
        this.operationMap = operationMap;
    }

    public Number calculate(Operation op, Number num1, Number num2) {
        OperationStrategy strategy = operationMap.get(op);
        if (strategy != null) {
            return strategy.apply(num1, num2);
        } else {
            throw new UnsupportedOperationException("Operation not supported");
        }
    }

    public Number chainCalculate(Number initial, Object... opsAndValues) {
        Number result = initial;
        for (int i = 0; i < opsAndValues.length; i += 2) {
            Operation op = (Operation) opsAndValues[i];
            Number value = (Number) opsAndValues[i + 1];
            result = calculate(op, result, value);
        }
        return result;
    }


    // Method to add an operation dynamically, if needed
    public void addOperation(Operation op, OperationStrategy strategy) {
        operationMap.put(op, strategy);
    }
}
