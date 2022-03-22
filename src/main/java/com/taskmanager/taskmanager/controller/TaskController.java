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
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@Slf4j
@RequestMapping(value = "api/task")
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
    public ResponseEntity<?> updateTask(@PathVariable Long id){
        TaskEntity taskEntity = this.taskService.updateTask(this.taskService.getTaskById(id));
        return new ResponseEntity<>(taskEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        this.taskService.deleteTask(id);
        return new ResponseEntity<>("task deleted", HttpStatus.OK);
    }
}
