package com.fryzjerappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "user_service_relation")
public class UserServicesRelation {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service services;
}
