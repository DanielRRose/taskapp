package com.drrose.taskapp.domain;

import java.time.LocalDate;

import com.drrose.taskapp.domain.entity.TaskPriority;
import com.drrose.taskapp.domain.entity.TaskStatus;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate duDate,
        TaskStatus status,
        TaskPriority priority
    ) {

}
