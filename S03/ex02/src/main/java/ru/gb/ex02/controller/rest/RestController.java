package ru.gb.ex02.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello, user!";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "Ciao, user!";
    }
}
