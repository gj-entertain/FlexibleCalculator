package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<Operation, OperationStrategy> operationMap() {
        Map<Operation, OperationStrategy> operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, new AddOperation());
        operationMap.put(Operation.SUBTRACT, new SubtractOperation());
        operationMap.put(Operation.MULTIPLY, new MultiplyOperation());
        operationMap.put(Operation.DIVIDE, new DivideOperation());
        return operationMap;
    }

    @Bean
    public Calculator calculator(Map<Operation, OperationStrategy> operationMap) {
        return new Calculator(operationMap);
    }
}
