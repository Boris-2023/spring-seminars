package ru.gb.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.ex02.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
