package ru.gb.task03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.task03.service.CalcService;

@Controller
public class CalcController {

    @Autowired
    private CalcService service;

    @GetMapping("/calc")
    public String printSolution(Model model){

        model.addAttribute("value1", service.getValue1());
        model.addAttribute("value2", service.getValue2());
        model.addAttribute("operator", service.getOperator());
        model.addAttribute("result", service.getResult());

        return "calc";
    }

    @PostMapping("/calc")
    public String newValues(
            Model model,
            CalcService s
    ){
        model.addAttribute("value1", s.getValue1());
        model.addAttribute("value2", s.getValue2());
        model.addAttribute("operator", s.getOperator());
        model.addAttribute("result", s.getResult());

        return "calc";
    }


}
