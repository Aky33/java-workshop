package com.calculator.calculator.controller;

import org.springframework.web.bind.annotation.*;

import com.calculator.calculator.model.Input;
import com.calculator.calculator.model.IntervalSplaceni;
import com.calculator.calculator.model.Output;
import com.calculator.calculator.service.CalculatorService;

@RestController
@RequestMapping("/")
public class CalculatorController {
    private CalculatorService service = new CalculatorService();

    @GetMapping("/intervali-splaceni")
    public IntervalSplaceni[] intervaliSplaceni() {
        return IntervalSplaceni.values();
    }

    @PostMapping("/vypocti")
    public Output vypocet(@RequestBody Input input) {
        return service.calculateMortgage(input);
    }
}