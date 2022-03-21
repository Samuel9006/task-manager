package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.entities.TaskEntity;
import com.taskmanager.taskmanager.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public ResponseEntity<?> getTasks(){
        log.info("get tasks service");
        List<TaskEntity> tasks = taskService.getTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id){
        TaskEntity task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> setTask(@RequestBody TaskEntity task){
        this.taskService.setTask(task);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long idTask){
        TaskEntity taskEntity = this.taskService.updateTask(this.taskService.getTaskById(idTask));
        return new ResponseEntity<>(taskEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long idTask){
        this.taskService.deleteTask(idTask);
        return new ResponseEntity<>("task deleted", HttpStatus.OK);
    }
}
