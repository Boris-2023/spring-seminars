package ru.gb.tasks.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.tasks.domain.Task;
import ru.gb.tasks.domain.types.TaskStatus;
import ru.gb.tasks.service.FileGateWay;
import ru.gb.tasks.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;
    private final FileGateWay gateWay;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        gateWay.writeToFile("log.txt", task.toString());
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
