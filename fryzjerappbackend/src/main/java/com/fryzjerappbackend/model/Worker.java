package com.fryzjerappbackend.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue
    private long workers_id;
    private String position;
    private long user_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roles_id")
    private Roles roles;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "workers_services",
            joinColumns = {@JoinColumn(name = "workers_id")},
            inverseJoinColumns = {@JoinColumn(name = "services_id")})
    private Set<Service> services = new HashSet<>();


    public Worker() {
    }

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
