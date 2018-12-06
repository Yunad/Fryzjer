package com.fryzjerappbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "services")
public class Service {


    @Id
    @GeneratedValue
    private long id;
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
