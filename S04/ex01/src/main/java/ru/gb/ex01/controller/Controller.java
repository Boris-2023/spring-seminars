package ru.gb.ex01.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/about")
    public String getAbout() {
        return "about.html";
    }
}
