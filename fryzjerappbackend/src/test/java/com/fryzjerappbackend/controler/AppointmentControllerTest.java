package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Appointment;
import com.fryzjerappbackend.service.AppointmentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;

import static com.fryzjerappbackend.controler.ControllerTestHelper.post;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class AppointmentControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AppointmentController appointmentController;

    @Mock
    private AppointmentService appointmentService;

    @Before
    public void setUpMocks() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).setHandlerExceptionResolvers().build();
    }

    @Test
    public void shouldSuccessfullyCreateAppointment() throws Exception {
        //given
        Appointment appointment = new Appointment();

        //then
        post(mockMvc, "/appointment/create", appointment).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldReturnAllAppointments() throws Exception {
        //given
        Appointment appointment = new Appointment();
        appointment.setDate("testDate");

        //when
        Mockito.when(appointmentService.getAllAppointments()).thenReturn((Collections.singletonList(appointment)));

        //then
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/appointment/get");

        //then
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.[0].date", is(equalTo(appointment.getDate()))))
                .andDo(MockMvcResultHandlers.print());
    }
}
