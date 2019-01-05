package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @NotNull
    @Column(name = "serviceId")
    private Long serviceId;

    @OneToMany(mappedBy = "appointmentId")
    private Set<UserAppointment> userAppointment;

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<UserAppointment> getUserAppointment() {
        return userAppointment;
    }

    public void setUserAppointment(Set<UserAppointment> userAppointment) {
        this.userAppointment = userAppointment;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", serviceId=" + serviceId +
                ", userAppointment=" + userAppointment +
                '}';
    }
}
