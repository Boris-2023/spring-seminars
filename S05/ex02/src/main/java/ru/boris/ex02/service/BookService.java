package ru.boris.ex02.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boris.ex02.model.Book;
import ru.boris.ex02.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(long id) {
        return repository.findById(id).orElseGet(null);
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return repository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    public void deleteBook(Book book) {
        repository.deleteById(book.getId());
    }
}
