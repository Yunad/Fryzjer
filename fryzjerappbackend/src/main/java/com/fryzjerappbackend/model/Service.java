package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Services")
public class Service {

    @Id
    @GeneratedValue
    @Column(name = "serviceId")
    private long serviceId;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "price")
    private double price;
    @NotNull
    @Column(name = "duration")
    private double duration;

    @OneToMany(mappedBy = "service")
    Set<UserServicesRelation> userServices;

    public Service() {
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;

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

}
