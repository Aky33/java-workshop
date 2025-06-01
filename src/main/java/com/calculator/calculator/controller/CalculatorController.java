package com.calculator.calculator.controller;

//import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

//import java.util.*;

@RestController
@RequestMapping("/")
public class CalculatorController {

    //private List<User> users = new ArrayList<>();

    @GetMapping
    public String helloWorld() {
        return "Hello World";
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