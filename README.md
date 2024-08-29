# Flexible Calculator

## Project Overview
This project implements a flexible and extensible calculator in Java. The calculator supports basic arithmetic operations (addition, subtraction, multiplication, division) and is designed to follow the Open-Closed Principle, allowing new operations to be added without modifying the existing code. The project also integrates Spring Framework for dependency injection and Inversion of Control (IoC).

## Features
- **Basic Operations**: Supports addition, subtraction, multiplication, and division.
- **Chained Operations**: Allows users to perform a series of operations starting from an initial value.
- **Extensibility**: New operations can be added by introducing new strategy classes without modifying the existing `Calculator` class.
- **Graceful Error Handling**: If an unsupported operation is requested, an `UnsupportedOperationException` is thrown with a clear error message.
- **Dependency Injection**: Utilizes Spring Framework for dependency injection, making the code more testable and maintainable.
- **Comprehensive Unit Testing**: Includes tests covering normal and edge cases.

## Assumptions
1. **Operand Types**: It is assumed that all operands are of type `Number`, which allows support for both integers and floating-point numbers.
2. **Operation Order**: It is assumed that operations in chained calculations are executed sequentially, passing the result of one operation as the input to the next.
3. **Division by Zero**: It is assumed that division by zero will throw an `ArithmeticException`.
4. **Unsupported Operations**: It is assumed that when an unsupported operation is requested, an `UnsupportedOperationException` will be thrown with a clear error message.

## Design Decisions
1. **Open-Closed Principle**: The Strategy Pattern is used to encapsulate each operation in its own strategy class (e.g., `AddOperation`, `SubtractOperation`), allowing the `Calculator` class to be extended with new operations without modifying its existing code.
2. **Dependency Injection**: Dependency injection is implemented using the Spring Framework, with the `AppConfig` class used for configuration. This allows for flexible management and extension of operation strategies.
3. **Error Handling**: Unsupported operations are handled by throwing an `UnsupportedOperationException`, which is a standard Java exception type used to indicate that an operation is not supported.
4. **Unit Testing**: JUnit 5 is used for testing, covering both basic functionality and edge cases, such as division by zero, unsupported operations, and operations involving negative numbers.

## Usage
1. Clone or download the project code.
2. Import the project into IntelliJ IDEA or any other IDE that supports Maven.
3. Ensure the Maven project is refreshed and all dependencies are downloaded.
4. Run the `Main` class to test the basic functionality of the calculator or run the `CalculatorTest` class to execute all unit tests.

## Dependencies
- Java 17
- Maven 3.6+
- Spring 5.3.9
- JUnit 5.8.1
