package com.groomerx.repository.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "APPOINTMENT_DETAILS")
@Data
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

//    @Column(name="DATE_CREATED")
//    private Timestamp date_created;

    @Column(name = "CREATED_BY")
    private int createdBy;

    @Column(name = "EMPLOYEE_ID")
    private int employeeID;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_CONTACT")
    private String clientContact;

    @Column(name = "START_TIME")
    private Timestamp startTime;

    @Column(name = "END_TIME")
    private Timestamp endTime;

    @Column(name = "END_TIME_EXPECTED")
    private Timestamp endTimeExpected;

    @Column(name = "PRICE_EXPECTED")
    private Double priceExpected;

    @Column(name = "PRICE_FULL")
    private Double priceFull;

    @Column(name = "DISCOUNT")
    private Double discount;

    @Column(name = "PRICE_FINAL")
    private Double priceFinal;

    @Column(name = "CANCELLED")
    private boolean cancelled;

    @Column(name = "CANCELLED_NOTE")
    private String cancelledNote;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID")
    private ClientEntity clientEntity;

    @OneToMany(mappedBy = "appointmentEntity", cascade = CascadeType.ALL)
    private List<ServicesBookedEntity> servicesBookedEntityList;



}
