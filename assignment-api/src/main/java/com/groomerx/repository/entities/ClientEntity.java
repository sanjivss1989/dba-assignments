package com.groomerx.repository.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
@Data
public class ClientEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "EMAIL")
    private String email;

}
