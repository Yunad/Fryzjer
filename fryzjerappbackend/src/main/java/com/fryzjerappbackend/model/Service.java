package com.fryzjerappbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Services")
public class Service {

    @Id
    @Column(name = "id")
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "price")
    private double price;
    @NotNull
    @Column(name = "duration")
    private double duration;
    @ManyToMany(mappedBy = "services")
    private Set<User> users = new HashSet<>();

    @JsonBackReference //blocks loops for rest calls
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceId")
    private List<Appointment> appointments = new ArrayList<>();

    public Service() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
