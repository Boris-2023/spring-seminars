package ru.gb.microService1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Controller {
    @GetMapping("/hello")
    public String hello(){
        return "Hello from MService #1!";
    }
}
