package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}
