package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.entities.EmployEntity;

import java.util.List;

public interface IEmployService {

    List<EmployEntity> employeesList();
    EmployEntity getEmployById(Long id);
}
