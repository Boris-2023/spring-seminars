package ru.gb.task02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalcController {

    /**
     * Sum of 2 values
     * @param model model to pass to Thymeleaf
     * @param v1    value #1
     * @param v2    value #2
     * @return sum of values
     * @apiNote takes input values from request parameters
     */
    @GetMapping("/sum")
    public String getSum(
            Model model,
            @RequestParam(name = "value1", defaultValue = "0") long v1,
            @RequestParam(name = "value2", defaultValue = "0") long v2
    ) {

        model.addAttribute("value1", v1);
        model.addAttribute("value2", v2);
        model.addAttribute("result", v1 + v2);

        return "sum";
    }

    /**
     * Difference of 2 values
     * @param model model to pass to Thymeleaf
     * @param v1    value #1
     * @param v2    value #2
     * @return difference of values
     * @apiNote takes input values from request path
     */
    @GetMapping("/deduct/{value1}/{value2}")
    public String getDifference(
            Model model,
            @PathVariable(name = "value1") long v1,
            @PathVariable(name = "value2") long v2
    ) {

        model.addAttribute("value1", v1);
        model.addAttribute("value2", v2);
        model.addAttribute("result", v1 - v2);

        return "deduct";
    }

    @RequestMapping
    public String getCalc(){
        return "calc";
    }

}
