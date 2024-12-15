package org.skypro.simple.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) throws IllegalArgumentException  {
        if (num2 == 0) {
            throw new IllegalArgumentException ("Деление на ноль недопустимо.");
        }
        return num1 / num2;
    }
}
