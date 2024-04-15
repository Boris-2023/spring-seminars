package ru.boris.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.boris.ex02.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
