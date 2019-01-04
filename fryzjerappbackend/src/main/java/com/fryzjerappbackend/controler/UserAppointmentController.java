package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.model.UserAppointment;
import com.fryzjerappbackend.service.UserAppoinmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserAppointmentController {

    private static final Logger LOG = LogManager.getLogger(com.fryzjerappbackend.controler.UserAppointmentController.class);

    @Autowired
    private UserAppoinmentService userAppoinmentService;

    @PostMapping("/create/user-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody UserAppointment userAppointment) {
        userAppoinmentService.createAppointmentService(userAppointment);
    }

    @GetMapping("get/user-appointments")
    @ResponseStatus(HttpStatus.OK)
    public List<UserAppointment> getUserAppointments() {
        return userAppoinmentService.getAllServices();
    }
}
