package ru.gb.ex02.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.ex02.model.Book;
import ru.gb.ex02.model.Reader;
import ru.gb.ex02.repository.BookRepository;
import ru.gb.ex02.repository.ReaderRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookRepository bookRepo;
    private final ReaderRepository readerRepo;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @PostMapping
    public Book addNewBook(@RequestBody Book book){
        return bookRepo.save(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id){
        return bookRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}/reader/{readerId}")
    public ResponseEntity<Book> assignReaderToBook(@PathVariable Long id, @PathVariable Long readerId) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        Optional<Reader> readerOptional = readerRepo.findById(readerId);

        if (bookOptional.isPresent() && readerOptional.isPresent()) {
            Book book = bookOptional.get();
            Reader reader = readerOptional.get();
            book.setReader(reader);
            bookRepo.save(book);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            bookRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
