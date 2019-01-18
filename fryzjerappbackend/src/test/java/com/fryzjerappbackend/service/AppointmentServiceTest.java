package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Appointment;
import com.fryzjerappbackend.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    private Optional<Appointment> createAppointmentTestObj() {
        String date = "2019-01-01";
        Long serviceID = 11L;
        Long id = 1L;

        Appointment testObj = new Appointment();
        testObj.setDate(date);
        testObj.setServiceId(serviceID);

        return Optional.of(testObj);
    }

    @Test
    public void shouldFindAppointmentById() {
        //given
        Optional<Appointment> appointmentTestObj = createAppointmentTestObj();
        Long testId = appointmentTestObj.get().getId();
        //when
        when(appointmentRepository.findAppointmentById(testId)).thenReturn(appointmentTestObj);

        //then
        Optional<Appointment> result = appointmentService.getAppointmentById(testId);

        verify(appointmentRepository, times(1)).findAppointmentById(testId);
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), testId);
        assertEquals(result.get().getServiceId(), appointmentTestObj.get().getServiceId());
        assertEquals(result.get().getDate(), appointmentTestObj.get().getDate());
    }

    @Test
    public void shouldNotFindAppointmentById() {
        //given
        //when
        //then
        Optional<Appointment> result = appointmentService.getAppointmentById(1L);

        verify(appointmentRepository, times(1)).findAppointmentById(1L);
        assertFalse(result.isPresent());
    }

    @Test
    public void shouldCreateAppointment() {
        //given
        Appointment appointment = new Appointment();

        //then
        appointmentService.createAppointment(appointment);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    public void shouldGetAllAppointments() {
        //given
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(createAppointmentTestObj().get());
        appointmentList.add(createAppointmentTestObj().get());

        //when
        when(appointmentRepository.findAll()).thenReturn(appointmentList);

        //then
        List<Appointment> result = appointmentService.getAllAppointments();
        verify(appointmentRepository, times(1)).findAll();
        assertEquals(result.size(), 2);
        assertEquals(result.size(), appointmentList.size());
    }
}
