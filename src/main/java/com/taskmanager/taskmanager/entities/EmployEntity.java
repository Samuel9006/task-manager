package com.taskmanager.taskmanager.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employ")
public class EmployEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String secondName;

    @Column
    private String documentId;
}
