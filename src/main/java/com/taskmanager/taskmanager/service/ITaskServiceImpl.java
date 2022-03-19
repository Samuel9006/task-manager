package com.taskmanager.taskmanager.service;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITaskServiceImpl implements ITaskService{

    @Override
    public List<Task> getTasks() {
        return null;
    }
}
