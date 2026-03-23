package com.drrose.taskapp.domain;

import java.time.LocalDate;

import com.drrose.taskapp.domain.entity.TaskPriority;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate duDate,
        TaskPriority priority) {

}
