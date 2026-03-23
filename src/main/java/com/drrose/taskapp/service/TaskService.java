package com.drrose.taskapp.service;

import java.util.List;
import java.util.UUID;

import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.UpdateTaskRequest;
import com.drrose.taskapp.domain.entity.Task;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void DeleteTask(UUID taskId);
}
