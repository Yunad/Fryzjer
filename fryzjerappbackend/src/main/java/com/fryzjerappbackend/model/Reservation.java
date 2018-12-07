package com.fryzjerappbackend.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue
    private long reservations_id;

    private double date;
    private double time;
    private long workers_id;
    private long users_id;

    public Reservation(double date, double time) {
        this.date = date;
        this.time = time;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "users_id")
    private Set<User> users = new HashSet<>();


    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
