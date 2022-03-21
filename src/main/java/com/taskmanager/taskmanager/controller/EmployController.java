package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.entities.EmployEntity;
import com.taskmanager.taskmanager.service.IEmployService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "employ")
@Slf4j
public class EmployController {

    @Autowired
    private IEmployService employService;

    @GetMapping
    public ResponseEntity<?> getEmploys(){
        List<EmployEntity> employeesList = employService.employeesList();
        return new ResponseEntity<>(employeesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployById(@PathVariable Long id){
        log.info("get employ with id {}", id);
        EmployEntity employById = this.employService.getEmployById(id);
        return new ResponseEntity<>(employById, HttpStatus.OK);
    }
}
