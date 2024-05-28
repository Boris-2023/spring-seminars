package ru.gb.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.hw10.domain.Task;
import ru.gb.hw10.domain.types.TaskStatus;
import ru.gb.hw10.repository.TaskRepository;
import ru.gb.hw10.service.TaskService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TaskServiceModuleTest {
    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    public void taskAddProperly() {

        // precondition
        Task task = new Task();
        task.setId(1L);
        task.setDescription("test_task_1");
        task.setStatus(TaskStatus.NOT_STARTED);
        task.setDate(LocalDateTime.now());

        // action
        service.addTask(task);

        // result check
        verify(repository).save(task);

    }

    @Test
    public void taskUpdateStatusProperly() {

        // precondition
        Task task = new Task();
        task.setId(1L);
        task.setDescription("test_task_1");
        task.setStatus(TaskStatus.NOT_STARTED);
        task.setDate(LocalDateTime.now());

        Task taskNewStatus = new Task();
        taskNewStatus.setId(1L);
        taskNewStatus.setDescription("test_task_1");
        taskNewStatus.setStatus(TaskStatus.COMPLETED);
        taskNewStatus.setDate(LocalDateTime.now());

        given(repository.findById(1L)).willReturn(Optional.of(task));// describe repo's behaviour

        // action
        service.updateTaskStatus(1L, taskNewStatus);

        // performance check
        verify(repository).findById(1L);
        verify(repository).save(task);

    }
}
