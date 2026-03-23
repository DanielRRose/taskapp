package com.drrose.taskapp.domain.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.drrose.taskapp.domain.entity.TaskPriority;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskRequestDto(
    @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
    @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
    String title,

    @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
    @Nullable
    String description,

    @FutureOrPresent(message = ERROR_MESSAGE_DUEDATE_FUTURE)
    @Nullable
    LocalDate dueDate,

    @NotNull(message = ERROR_MESSAGE_PRIORITY)
    TaskPriority priority
) {

    private static final String ERROR_MESSAGE_TITLE_LENGTH = 
    "Must be between 1 and 255 characters";

    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH = 
    "Must be between 1 and 1000 characters";

    private static final String ERROR_MESSAGE_DUEDATE_FUTURE = 
    "Must be present or future date";

    private static final String ERROR_MESSAGE_PRIORITY = 
    "Task priority cannot be null";
}
