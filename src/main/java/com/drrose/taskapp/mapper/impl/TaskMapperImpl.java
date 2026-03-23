package com.drrose.taskapp.mapper.impl;

import org.springframework.stereotype.Component;

import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.dto.CreateTaskReqestDto;
import com.drrose.taskapp.domain.dto.TaskDto;
import com.drrose.taskapp.domain.entity.Task;
import com.drrose.taskapp.mapper.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public CreateTaskRequest fromDto(CreateTaskReqestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.taskPriority());
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getTaskPriority(),
                task.getTaskStatus()

        );
    }

}
