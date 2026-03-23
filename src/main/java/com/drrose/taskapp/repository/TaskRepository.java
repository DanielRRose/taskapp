package com.drrose.taskapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drrose.taskapp.domain.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>{

}
