package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "This is a protected endpoint.";
    }
}