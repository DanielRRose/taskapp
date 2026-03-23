package com.drrose.taskapp.mapper;

import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.dto.CreateTaskRequestDto;
import com.drrose.taskapp.domain.dto.TaskDto;
import com.drrose.taskapp.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
