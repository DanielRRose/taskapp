package com.drrose.taskapp.service;

import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.entity.Task;

public interface TaskService {

    Task createTask(CreateTaskRequest request);
}
