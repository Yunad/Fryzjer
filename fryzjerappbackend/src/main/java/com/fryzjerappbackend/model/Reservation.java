package com.fryzjerappbackend.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue
    private long reservations_id;

    private double date;
    private double time;

    public Reservation(double date, double time) {
        this.date = date;
        this.time = time;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client users;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "workers_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Worker workers;

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
