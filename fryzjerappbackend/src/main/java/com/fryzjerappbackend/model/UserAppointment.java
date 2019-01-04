package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UserAppointments")
public class UserAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "userId")
    private Long userId;
    @NotNull
    @Column(name = "appointmentId")
    private Long appointmentId;

    public UserAppointment() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Long getId() {
        return id;
    }

    public void setAppointmentId(Long appointmentId) {

        this.appointmentId = appointmentId;
    }
}
