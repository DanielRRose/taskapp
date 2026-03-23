package com.drrose.taskapp.service.impl;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.entity.Task;
import com.drrose.taskapp.domain.entity.TaskStatus;
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
                request.duDate(),
                request.priority(),
                TaskStatus.OPEN,
                now);

        // System.out.println(task.toString());

        return taskRepository.save(task);

    }

}
