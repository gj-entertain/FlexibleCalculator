package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = context.getBean(Calculator.class);

        System.out.println("5 + 3 = " + calculator.calculate(Operation.ADD, 5, 3));
        System.out.println("10 - 2 = " + calculator.calculate(Operation.SUBTRACT, 10, 2));
        System.out.println("4 * 2 = " + calculator.calculate(Operation.MULTIPLY, 4, 2));
        System.out.println("20 / 4 = " + calculator.calculate(Operation.DIVIDE, 20, 4));

        // Chaining example
        System.out.println("Chaining: 5 + 3 * 2 = " + calculator.chainCalculate(5, Operation.ADD, 3, Operation.MULTIPLY, 2));
    }
}
