package com.groomerx.repository.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class ClientEntity {

    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "EMAIL")
    private String email;

}
