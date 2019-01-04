package com.fryzjerappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "UserServiceRelations")
public class UserServicesRelation {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service service;
}