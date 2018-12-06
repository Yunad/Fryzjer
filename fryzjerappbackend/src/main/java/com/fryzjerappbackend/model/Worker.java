package com.fryzjerappbackend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue
    private long id;
    private String position;
    private long user_id;

    public Worker(String position, long user_id) {
        this.position = position;
        this.user_id = user_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }


}
