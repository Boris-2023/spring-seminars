package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
