package com.example;

public class AddOperation implements OperationStrategy {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}
