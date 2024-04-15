package ru.boris.ex02.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.boris.ex02.model.Book;
import ru.boris.ex02.service.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class Controller {
    private final BookService service;

    @GetMapping
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }
}
