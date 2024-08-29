package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(8, calculator.calculate(Operation.ADD, 5, 3));
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(3, calculator.calculate(Operation.SUBTRACT, 10, 7));
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(20, calculator.calculate(Operation.MULTIPLY, 5, 4));
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(5, calculator.calculate(Operation.DIVIDE, 20, 4));
    }

    @Test
    void testDivisionByZero() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 5, 0);
        });
    }

    @Test
    void testUnsupportedOperation() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 5, 3);
        });
    }

    @Test
    void testChainingOperations() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(16, calculator.chainCalculate(5, Operation.ADD, 3, Operation.MULTIPLY, 2));
    }

    @Test
    void testNegativeNumberOperation() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(-2, calculator.calculate(Operation.ADD, -5, 3));
        assertEquals(-8, calculator.calculate(Operation.SUBTRACT, -5, 3));
    }

    @Test
    void testLargeNumberOperation() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(Double.MAX_VALUE, calculator.calculate(Operation.ADD, Double.MAX_VALUE, 0));
        assertEquals(Double.MIN_VALUE, calculator.calculate(Operation.SUBTRACT, Double.MIN_VALUE, 0));
    }

    @Test
    void testChainCalculateEdgeCase() {
        Calculator calculator = new Calculator(new AppConfig().operationMap());
        assertEquals(10, calculator.chainCalculate(5, Operation.ADD, 5));
        assertEquals(25, calculator.chainCalculate(5, Operation.ADD, 5, Operation.MULTIPLY, 5));
    }


}
