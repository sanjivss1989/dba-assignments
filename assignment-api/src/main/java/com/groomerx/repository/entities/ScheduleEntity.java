package com.groomerx.repository.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SCHEDULE")
@Data
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    @Column(name = "EMPLOYEE_ID")
    private int employeeID;

    @Column(name = "FROM_TIME")
    private Timestamp fromTime;

    @Column(name = "TO_TIME")
    private Timestamp toTime;
}
