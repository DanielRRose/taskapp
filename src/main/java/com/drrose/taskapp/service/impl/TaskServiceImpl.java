package com.drrose.taskapp.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort.Direction;
import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.UpdateTaskRequest;
import com.drrose.taskapp.domain.entity.Task;
import com.drrose.taskapp.domain.entity.TaskStatus;
import com.drrose.taskapp.exception.TaskNotFoundException;
import com.drrose.taskapp.repository.TaskRepository;
import com.drrose.taskapp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {

        Instant now = Instant.now();

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                request.priority(),
                TaskStatus.OPEN,
                now,
                now);

        // System.out.println(task.toString());

        return taskRepository.save(task);

    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {

        Instant now = Instant.now();

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setTaskStatus(request.status());
        task.setTaskPriority(request.priority());
        task.setUpdated(now);

        return taskRepository.save(task);
    }

    @Override
    public void DeleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
        
    }

    

}
