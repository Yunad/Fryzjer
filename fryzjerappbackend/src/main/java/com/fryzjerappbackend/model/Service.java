package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceId")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "serviceId")
    private Set<UserServiceRelation> userServices;

    public Service() {
    }

    public Set<UserServiceRelation> getUserServices() {
        return userServices;
    }

    public void setUserServices(Set<UserServiceRelation> userServices) {
        this.userServices = userServices;
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

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", appointments=" + appointments +
                ", userServices=" + userServices +
                '}';
    }
}
