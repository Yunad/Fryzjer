package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.UserAppointment;
import com.fryzjerappbackend.service.AppointmentService;
import com.fryzjerappbackend.service.UserAppoinmentService;
import com.fryzjerappbackend.service.UserService;
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

import java.util.Collections;

import static com.fryzjerappbackend.controler.ControllerTestHelper.post;

public class UserAppointmentControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserAppointmentController appointmentController;

    @Mock
    private UserAppoinmentService userAppoinmentService;

    @Mock
    private UserService userService;

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
        UserAppointment appointment = new UserAppointment();
        appointment.setUserId(1L);
        appointment.setAppointmentId(1L);

        //then
        post(mockMvc, "/user-appointment/create", appointment).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldReturnAllAppointments() throws Exception {
        //given
        UserAppointment appointment = new UserAppointment();
        appointment.setAppointmentId(1L);
        appointment.setUserId(1L);

        //when
        Mockito.when(userAppoinmentService.getAllServices()).thenReturn((Collections.singletonList(appointment)));

        //then
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user-appointment/get");

        //then
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
