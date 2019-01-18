package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.UserAppointment;
import com.fryzjerappbackend.repository.UserAppoinmentServiceRepository;
import com.fryzjerappbackend.repository.UserAppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAppointmentServiceTest {

    @MockBean
    private UserAppoinmentServiceRepository userAppointmentRepository;

    @Autowired
    private UserAppoinmentService userAppoinmentService;

    @Test
    public void shouldGetAllServices() {
        //given
        List<UserAppointment> appointmentList = new ArrayList<>();
        UserAppointment appointment = new UserAppointment();
        appointment.setAppointmentId(1L);
        appointment.setUserId(1L);

        UserAppointment appointment2 = new UserAppointment();
        appointment.setAppointmentId(2L);
        appointment.setUserId(2L);

        appointmentList.add(appointment);
        appointmentList.add(appointment2);

        //when
        when(userAppointmentRepository.findAll()).thenReturn(appointmentList);

        //then
        List<UserAppointment> result = userAppoinmentService.getAllServices();
        verify(userAppointmentRepository, times(1)).findAll();
        assertEquals(result.size(), 2);
        assertEquals(result.size(), appointmentList.size());
    }

    @Test
    public void shouldCreateService() {
        //given
        UserAppointment appointment = new UserAppointment();
        appointment.setAppointmentId(1L);
        appointment.setUserId(1L);

        //when

        //then
        userAppoinmentService.createAppointmentService(appointment);
        verify(userAppointmentRepository, times(1)).save(appointment);
    }
}
