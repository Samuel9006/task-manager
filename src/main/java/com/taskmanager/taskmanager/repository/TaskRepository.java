package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

    List<TaskEntity> findAll();
}
