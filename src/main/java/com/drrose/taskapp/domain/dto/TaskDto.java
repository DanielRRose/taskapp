package com.drrose.taskapp.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.drrose.taskapp.domain.entity.TaskPriority;
import com.drrose.taskapp.domain.entity.TaskStatus;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDate dueDate,
    TaskPriority priority,
    TaskStatus status
) {

}
