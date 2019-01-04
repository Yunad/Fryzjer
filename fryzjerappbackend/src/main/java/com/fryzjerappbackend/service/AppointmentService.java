package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Appointment;
import com.fryzjerappbackend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
