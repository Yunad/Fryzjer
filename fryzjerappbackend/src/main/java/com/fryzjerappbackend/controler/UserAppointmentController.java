package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Appointment;
import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.model.UserAppointment;
import com.fryzjerappbackend.service.AppointmentService;
import com.fryzjerappbackend.service.UserAppoinmentService;
import com.fryzjerappbackend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-appointment")
public class UserAppointmentController {

    @Autowired
    private UserAppoinmentService userAppoinmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    private static final Logger LOG = LogManager.getLogger(com.fryzjerappbackend.controler.UserAppointmentController.class);

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody UserAppointment userAppointment) {
        final Optional<User> userById = userService.getUserById(userAppointment.getUserId());
        final Optional<Appointment> appointmentById = appointmentService.getAppointmentById(userAppointment.getAppointmentId());

        LOG.info("User {} has been appointed to {}", userById, appointmentById);
        userAppoinmentService.createAppointmentService(userAppointment);
    }

    @GetMapping("get")
    @ResponseStatus(HttpStatus.OK)
    public List<UserAppointment> getUserAppointments() {
        return userAppoinmentService.getAllServices();
    }
}
