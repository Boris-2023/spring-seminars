package ru.gb.hw07.controller;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.hw07.service.PrivateService;
import ru.gb.hw07.service.HomeService;
import ru.gb.hw07.service.PublicService;

@Controller
public class HomeController {

    private final HomeService homeService;
    private final PublicService publicService;
    private final PrivateService privateService;

    public HomeController(HomeService homeService, PublicService publicService, PrivateService privateService) {
        this.homeService = homeService;
        this.publicService = publicService;
        this.privateService = privateService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("text", homeService.getText());
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/public-data")
    public String user(Model model) {
        model.addAttribute("text", publicService.getText());
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin(Model model) {

        model.addAttribute("text", privateService.getText());
        return "private-data";
    }

}
