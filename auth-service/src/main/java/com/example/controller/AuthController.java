package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return Collections.singletonMap("message", "Login Successful");
        } else {
            return Collections.singletonMap("message", "Login Failed");
        }
    }
}
