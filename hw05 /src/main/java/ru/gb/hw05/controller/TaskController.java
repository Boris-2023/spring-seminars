package ru.gb.hw05.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw05.domain.Task;
import ru.gb.hw05.domain.types.TaskStatus;
import ru.gb.hw05.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }

    @GetMapping("/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.getTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTaskStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTaskById(id);
    }

}
