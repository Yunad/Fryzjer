package com.fryzjerappbackend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rights")
public class Right {

    @Id
    @GeneratedValue
    private long rights_id;
    private String name;

    public Right(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "rights", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Worker> workers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
