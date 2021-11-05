package com.groomerx.repository.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SERVICE_PROVIDED")
@Data
public class ServicesBookedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "APPOINTMENT_ID")
    private AppointmentEntity appointmentEntity;

    @Column(name = "SERVICE_ID")
    private String serviceID;

    @Column(name = "PRICE")
    private Double price;
}
