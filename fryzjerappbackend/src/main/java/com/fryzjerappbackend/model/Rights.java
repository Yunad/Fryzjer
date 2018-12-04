package com.fryzjerappbackend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rights")
public class Rights {
    private long id;
    private String name;


}
