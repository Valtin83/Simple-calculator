package org.skypro.simple.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class CalculatorServiceTest {

    private final CalculatorService calc = new CalculatorService();

    // Параметризованный тест для сложения
    @ParameterizedTest
    @MethodSource("additionArgumentsProvider")
    void add(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calc.add(num1, num2),
                "%s + %s должно быть %s".formatted(num1, num2, expected));
    }

    // Параметризованный тест для вычитания
    @ParameterizedTest
    @MethodSource("subtractionArgumentsProvider")
    void subtract(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calc.subtract(num1, num2),
                "%s - %s должно быть %s".formatted(num1, num2, expected));
    }

    // Параметризованный тест для умножения
    @ParameterizedTest
    @MethodSource("multiplicationArgumentsProvider")
    void multiply(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calc.multiply(num1, num2),
                "%s * %s должно быть %s".formatted(num1, num2, expected));
    }

    // Параметризованный тест для деления
    @ParameterizedTest
    @MethodSource("divisionArgumentsProvider")
    void divide(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calc.divide(num1, num2),
                "%s / %s должно быть %s".formatted(num1, num2, expected));

    }

    // Тест для деления на ноль
    @ParameterizedTest
    @MethodSource("divisionByZeroArgumentsProvider")
    void divideByZeroThrowsException(Double num1) {
        Assertions.assertThrows(IllegalArgumentException .class, () -> calc.divide(num1, 0.0),
                "Деление на ноль должно вызывать исключение");
    }

    // Провайдер аргументов для сложения
    static Stream<Arguments> additionArgumentsProvider() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5),
                Arguments.of(-1, 1, 0),
                Arguments.of(-1, -1, -2)
        );
    }

    // Провайдер аргументов для вычитания
    static Stream<Arguments> subtractionArgumentsProvider() {
        return Stream.of(
                Arguments.of(3, 2, 1),
                Arguments.of(5, 2, 3),
                Arguments.of(-1, 1, -2),
                Arguments.of(-1, -1, 0)
        );
    }

    // Провайдер аргументов для умножения
    static Stream<Arguments> multiplicationArgumentsProvider() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(-2, 3, -6),
                Arguments.of(0, 5, 0),
                Arguments.of(-2, -3, 6)
        );
    }

    // Провайдер аргументов для деления
    static Stream<Arguments> divisionArgumentsProvider() {
        return Stream.of(
                Arguments.of(6, 3, 2),
                Arguments.of(-6, 3, -2),
                Arguments.of(0, 5, 0),
                Arguments.of(10, 2, 5)
        );
    }

    // Аргументы для проверки деления на ноль
    private static Stream<Arguments> divisionByZeroArgumentsProvider() {
        return Stream.of(
                Arguments.of(1.0),
                Arguments.of(-1.0),
                Arguments.of(100.0),
                Arguments.of(0.0)
        );
    }
}