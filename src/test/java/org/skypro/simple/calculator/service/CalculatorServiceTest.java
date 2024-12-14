package org.skypro.simple.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {

    private final CalculatorService calc = new CalculatorService();

    @Test
    void add() {
        assertEquals(5, calc.add(2, 3), "2 + 3 должно быть 5");
        assertEquals(10, calc.add(7, 3), "7 + 3 должно быть 10");
        assertEquals(6, calc.add(3, 3), "3 + 3 должно быть 6");

    }

    @Test
    void subtract() {
        assertEquals(1, calc.subtract(3, 2), "3 - 2 должно быть 1");
        assertEquals(-1, calc.subtract(2, 3), "2 - 3 должно быть -1");
        assertEquals(0, calc.subtract(3, 3), "3 - 3 должно быть 0");
    }

    @Test
    void multiply() {
        assertEquals(6, calc.multiply(2, 3), "2 * 3 должно быть 6");
        assertEquals(0, calc.multiply(0, 5), "0 * 5 должно быть 0");
        assertEquals(-6, calc.multiply(-2, 3), "-2 * 3 должно быть -6");
    }

    @Test
    void divide() {
        assertEquals(2, calc.divide(6, 3), "6 / 3 должно быть 2");
        assertEquals(0, calc.divide(0, 5), "0 / 5 должно быть 0");
        assertThrows(IllegalArgumentException.class, () -> { calc.divide(1, 0);
        }, "Деление на ноль должно вызывать ArithmeticException");
    }
}