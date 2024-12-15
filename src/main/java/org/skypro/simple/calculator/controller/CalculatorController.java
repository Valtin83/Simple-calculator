package org.skypro.simple.calculator.controller;

import org.skypro.simple.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор!" +
                "Используйте операции: plus, minus, multiply, divide. " +
                "Например: /calculator/calculate?num1=5&num2=3&operation=plus";
    }

    @GetMapping(value = "/calculate")
    public String calculate(@RequestParam Double num1, @RequestParam Double num2,
                            @RequestParam String operation) {
        double result;
        try {
            switch (operation) {
                case "plus":
                    result = calculatorService.add(num1, num2);
                    operation = " + ";
                    break;
                case "minus":
                    result = calculatorService.subtract(num1, num2);
                    operation = " - ";
                    break;
                case "multiply":
                    result = calculatorService.multiply(num1, num2);
                    operation = " * ";
                    break;
                case "divide":
                    result = calculatorService.divide(num1, num2);
                    operation = " / ";
                    break;
                default:
                    return "Ошибка: Неизвестная операция.";
            }
            return String.format("%s %s %s = %s", num1, operation, num2, result);
        } catch (IllegalArgumentException e) {
            return "Ошибка: " + e.getMessage();
        }
    }
}

