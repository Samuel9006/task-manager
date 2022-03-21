package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.entities.EmployEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployRepository extends CrudRepository<EmployEntity, Long> {

    List<EmployEntity> findAll();
}
