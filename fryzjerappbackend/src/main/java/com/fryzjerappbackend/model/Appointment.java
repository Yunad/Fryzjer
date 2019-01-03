package com.fryzjerappbackend.model;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Service service;

    @OneToMany(mappedBy = "appointment")
    Set<UserAppointment> userAppointment;

}
