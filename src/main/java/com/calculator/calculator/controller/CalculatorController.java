package com.calculator.calculator.controller;

//import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import com.calculator.calculator.model.Input;
import com.calculator.calculator.model.IntervalSplaceni;
import com.calculator.calculator.model.Output;
import com.calculator.calculator.service.CalculatorService;

//import java.util.*;

@RestController
@RequestMapping("/")
public class CalculatorController {
    private CalculatorService service = new CalculatorService();

    //private List<User> users = new ArrayList<>();

    @GetMapping("/intervali-splaceni")
    public IntervalSplaceni[] intervaliSplaceni() {
        return IntervalSplaceni.values();
    }

    @PostMapping
    public Output vypocet(@RequestBody Input input) {
        return service.calculateMortgage(input);
    }

    /*@GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }*/
}