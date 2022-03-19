package com.taskmanager.taskmanager.entities;


import com.sun.istack.NotNull;
import com.taskmanager.taskmanager.enums.StateEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "tasking")
public class TaskEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    private String description;

    @Enumerated
    private StateEnum state;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="execution_date")
    private Date executionDate;

    @Temporal(TemporalType.DATE)
    @Column(name="late_date")
    private Date lateDays;

    @NotNull
    @Column(name = "employ_id")
    private Long employId;
}