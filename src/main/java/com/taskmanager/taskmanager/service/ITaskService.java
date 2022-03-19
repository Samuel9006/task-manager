package com.taskmanager.taskmanager.service;

import org.springframework.scheduling.config.Task;

import java.util.List;

public interface ITaskService {

    public List<Task> getTasks();

}
