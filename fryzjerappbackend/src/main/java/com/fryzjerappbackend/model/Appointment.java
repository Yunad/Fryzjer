package com.fryzjerappbackend.model;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;

    @OneToMany(mappedBy = "appointmentId")
    Set<UserAppointment> userAppointment;

    //    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    private Service service;
//
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "appointmentServices", joinColumns = @JoinColumn(name = "appointmentId"), inverseJoinColumns = @JoinColumn(name = "serviceId"))
    private Set<Service> services = new HashSet<>();

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Set<UserAppointment> getUserAppointment() {
        return userAppointment;
    }

    public void setUserAppointment(Set<UserAppointment> userAppointment) {
        this.userAppointment = userAppointment;
    }

}
