package com.fryzjerappbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue
    private long rights_id;
    private String name;

    public Roles(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Worker> workers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
