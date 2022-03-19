package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public String getTask(){
        log.info("get tasks service");
        List<Task> tasks = taskService.getTasks();
        return "prueba servicio";
    }
}
