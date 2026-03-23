package com.drrose.taskapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drrose.taskapp.domain.CreateTaskRequest;
import com.drrose.taskapp.domain.dto.CreateTaskReqestDto;
import com.drrose.taskapp.domain.dto.TaskDto;
import com.drrose.taskapp.domain.entity.Task;
import com.drrose.taskapp.mapper.TaskMapper;
import com.drrose.taskapp.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(

            @RequestBody
            @Valid
            CreateTaskReqestDto createTaskReqestDto) {

        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskReqestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDto(task);

        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }
}
