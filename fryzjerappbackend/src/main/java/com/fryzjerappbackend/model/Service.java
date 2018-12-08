package com.fryzjerappbackend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {


    @Id
    @GeneratedValue
    private long services_id;
    @NotNull
    @Size(max = 50)
    private String service_type;
    @NotNull
    private double price;
    @NotNull
    private double time;

    public Service(String service_type, double price, double time) {
        this.service_type = service_type;
        this.price = price;
        this.time = time;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "services")
    private Set<Worker> worker = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "workers_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Worker workers;

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
