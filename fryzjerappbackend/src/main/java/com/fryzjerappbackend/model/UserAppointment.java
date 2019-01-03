package com.fryzjerappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "UserAppointments")
public class UserAppointment {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;

}
