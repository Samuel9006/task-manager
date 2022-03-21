package com.taskmanager.taskmanager.serviceImpl;

import com.taskmanager.taskmanager.entities.EmployEntity;
import com.taskmanager.taskmanager.repository.EmployRepository;
import com.taskmanager.taskmanager.service.IEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployServiceImpl implements IEmployService {

    @Autowired
    private EmployRepository employRepository;

    @Override
    public List<EmployEntity> employeesList() {
        return employRepository.findAll();
    }

    @Override
    public EmployEntity getEmployById(Long id) {
        return this.employRepository.findById(id).get();
    }
}
