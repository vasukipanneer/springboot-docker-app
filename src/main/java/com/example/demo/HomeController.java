package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//REST Controller for Home API
@RestController
public class HomeController {

	// API endpoint
    @GetMapping("/")
    public String home() {
        return "Spring Boot Docker Application Running!";
    }
}