package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.entities.TaskEntity;

import java.util.List;

public interface ITaskService {

    List<TaskEntity> getTasks();
    TaskEntity getTaskById(Long idTask);
    void setTask(TaskEntity task);
    TaskEntity updateTask (TaskEntity task);
    void deleteTask (Long idTask);
}
