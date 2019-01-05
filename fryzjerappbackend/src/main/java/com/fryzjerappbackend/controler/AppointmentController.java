package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Appointment;
import com.fryzjerappbackend.service.AppointmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private static final Logger LOG = LogManager.getLogger(com.fryzjerappbackend.controler.AppointmentController.class);

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAppointment(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);
        LOG.info("Appointment {} has been created.", appointment);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getApointments() {
        return appointmentService.getAllAppointments();
    }
}

