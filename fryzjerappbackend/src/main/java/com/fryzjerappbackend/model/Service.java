package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue
    private long service_id;
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private double duration;

    @OneToMany(mappedBy = "services")
    Set<UserServicesRelation> userServices;

    public Service(String name, double price, double duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
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

}
