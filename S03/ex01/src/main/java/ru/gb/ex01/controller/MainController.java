package ru.gb.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //to allow map of controllers to understand that it is for it
public class MainController {

    // first controller
    @RequestMapping("/home")
    public String getHome(){
        return "home.html";
    }

    @RequestMapping("/cats")
    public String getCats(){
        return"cats.html";
    }

    @RequestMapping("/game")
    public String getGame(){
        return"game.html";
    }
}
