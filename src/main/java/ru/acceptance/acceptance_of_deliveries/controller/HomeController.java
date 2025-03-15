package ru.acceptance.acceptance_of_deliveries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}