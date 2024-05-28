package ru.gb.hw10.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.hw10.domain.Task;
import ru.gb.hw10.domain.types.TaskStatus;
import ru.gb.hw10.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    public Task addTask(Task task) {
        repository.save(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findAll().stream()
                .filter(x -> x.getStatus() == status)
                .toList();
    }

    public Task updateTaskStatus(Long id, Task task) {
        Optional<Task> optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            Task destinationTask = optionalTask.get();
            destinationTask.setStatus(task.getStatus());
            return repository.save(destinationTask);
        } else {
            throw new IllegalArgumentException("No task found with id: " + id);
        }
    }

    public void deleteTaskById(Long id) {
        Task task = repository.findById(id).orElseGet(null);
        if (task != null) repository.delete(task);
    }

}
