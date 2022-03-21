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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "document_id")
    private String documentId;
}
