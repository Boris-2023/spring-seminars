package ru.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.domain.Task;
import ru.gb.aspect.TrackUserAction;
import ru.gb.domain.types.TaskStatus;
import ru.gb.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    @TrackUserAction
    public Task addTask(Task task) {
        repository.save(task);
        return task;
    }

    @TrackUserAction
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findAll().stream()
                .filter(x -> x.getStatus() == status)
                .toList();
    }

    @TrackUserAction
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

    @TrackUserAction
    public void deleteTaskById(Long id) {
        Task task = repository.findById(id).orElseGet(null);
        if (task != null) repository.delete(task);
    }

}
