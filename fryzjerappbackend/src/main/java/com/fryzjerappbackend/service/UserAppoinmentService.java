package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.model.UserAppointment;
import com.fryzjerappbackend.repository.UserAppoinmentServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppoinmentService {

    private UserAppoinmentServiceRepository userAppoinmentServiceRepository;

    @Autowired
    public UserAppoinmentService(UserAppoinmentServiceRepository userAppoinmentServiceRepository) {
        this.userAppoinmentServiceRepository = userAppoinmentServiceRepository;
    }

    public void createAppointmentService(UserAppointment userAppointment) {
        userAppoinmentServiceRepository.save(userAppointment);
    }

    public List<UserAppointment> getAllServices() {
        return userAppoinmentServiceRepository.findAll();
    }
}
