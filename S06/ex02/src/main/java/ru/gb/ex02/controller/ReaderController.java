package ru.gb.ex02.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.ex02.model.Reader;
import ru.gb.ex02.repository.ReaderRepository;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository repository;

    @GetMapping
    public List<Reader> getAllReaders(){
        return repository.findAll();
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader){
        return repository.save(reader);
    }
}
