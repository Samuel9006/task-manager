package com.taskmanager.taskmanager.entities;


import com.sun.istack.NotNull;
import com.taskmanager.taskmanager.enums.StateEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Data
@Table(name = "tasking")
public class TaskEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title_task")
    private String title;
    private String description;

    @Enumerated
    private StateEnum state;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="execution_date")
    private Date executionDate;

    @Temporal(TemporalType.DATE)
    private Date executionHour;

    @Column(name="late_date")
    private Integer lateDays;

    @NotNull
    @Column(name = "employ_id")
    private Long employId;

    private LocalDate convertToLocalDateViaInstant;

    @PrePersist
    private void preInsert(){
        this.getCalculates();
    }

    @PreUpdate
    private void preUpdate(){
        this.getCalculates();
    }

    private void getCalculates(){
        LocalDate today = LocalDate.now();
        LocalDate convertToLocalDateViaInstant = this.convertToLocalDateViaInstant(this.getExecutionDate());
        if(convertToLocalDateViaInstant.isBefore(today) && this.getState().equals(StateEnum.PENDIENTE)){
            Period period = Period.between(today, convertToLocalDateViaInstant);
            int diff = period.getDays();
            this.setLateDays(Math.abs(diff));
        }else{
            this.setLateDays(0);
        }
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
    }
}
