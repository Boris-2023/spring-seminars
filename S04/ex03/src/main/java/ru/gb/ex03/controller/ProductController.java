package ru.gb.ex03.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.ex03.model.Product;
import ru.gb.ex03.repository.ProductRepository;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductRepository repository; // inits by constructor - Lombok

    @GetMapping("/products")
    public String getProduct(Model model) {
        model.addAttribute("products", repository.getProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model ) {
        repository.addProduct(p);
        model.addAttribute("products", repository.getProducts());
        return "products";
    }

}
