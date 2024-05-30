package ru.gb.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.tasks.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
