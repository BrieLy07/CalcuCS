package com.example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @GetMapping
    public String showCalculatorForm(Model model) {
        model.addAttribute("calculatorForm", new CalculatorForm());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double num1, @RequestParam double num2, Model model) {
        double result = num1 + num2;  // Cambia esto según la operación deseada
        model.addAttribute("result", result);
        return "calculator";
    }

    @PostMapping("/add")
    public double add(@RequestParam double num1, @RequestParam double num2) {
        return num1 + num2;
    }

    @PostMapping("/subtract")
    public double subtract(@RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }

    @PostMapping("/multiply")
    public double multiply(@RequestParam double num1, @RequestParam double num2) {
        return num1 * num2;
    }

    @PostMapping("/divide")
    public double divide(@RequestParam double num1, @RequestParam double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }

    @GetMapping("/home")
    public String home() {
        return "Bienvenido a la aplicación de calculadora";
    }
}
