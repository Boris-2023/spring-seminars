package ru.gb.hw10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hw10.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
