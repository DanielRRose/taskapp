package com.drrose.taskapp.mapper;

import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.dto.CreateTaskReqestDto;
import com.drrose.taskapp.domain.dto.TaskDto;
import com.drrose.taskapp.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskReqestDto dto);

    TaskDto toDto(Task task);
}
