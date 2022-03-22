package com.taskmanager.taskmanager.serviceImpl;

import com.taskmanager.taskmanager.entities.TaskEntity;
import com.taskmanager.taskmanager.repository.TaskRepository;
import com.taskmanager.taskmanager.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskEntity> getTasks() {
        log.info("Get all tasks");
        return taskRepository.findAll();
    }

    @Override
    public TaskEntity getTaskById(Long idTask) {
        log.info("Get the task with id {}" ,idTask);
        return this.taskRepository.findById(idTask).get();
    }

    @Override
    public TaskEntity setTask(TaskEntity task) {
        log.info("The task is setting {}" ,task);
        return this.taskRepository.save(task);
    }

    @Override
    public TaskEntity updateTask(TaskEntity task) {
        log.info("The task is updating {}" ,task);
        return this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long idTask) {
        log.info("The taks is deleting {}" ,idTask);
        this.taskRepository.delete(taskRepository.findById(idTask).get());
    }
}
