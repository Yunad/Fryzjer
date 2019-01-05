package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class UserServiceRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    @NotNull
    private Long userId;

    @Column(name = "serviceId")
    @NotNull
    private Long serviceId;

    public UserServiceRelation() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "UserServiceRelation{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                '}';
    }
}
