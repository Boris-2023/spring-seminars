package ru.gb.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.ex02.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
