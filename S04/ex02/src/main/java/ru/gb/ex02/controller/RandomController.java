package ru.gb.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {
    Random rnd = new Random();

    @GetMapping("/random")
    public String getRandom(Model model) {
        int number = rnd.nextInt(100);
        model.addAttribute("number", number);
        return "random";
    }

    // path variables
    @GetMapping("/random/{min}/{max}")
    public String getMinMaxRandom(Model model, @PathVariable(name = "min") int min, @PathVariable int max) {
        int number = rnd.nextInt(min, max + 1);

        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", number);

        return "randomMiMa";
    }

    // parameters variables
    @GetMapping("/randomMiMa")
    public String getRandomNumEx(
            @RequestParam(name = "min", defaultValue = "1") int min,
            @RequestParam(defaultValue = "100") int max,
            Model model) {

        int num = rnd.nextInt(min, max + 1);

        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", num);

        return "randomMiMa";
    }

}
