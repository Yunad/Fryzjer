package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Appointment;
import com.fryzjerappbackend.model.Service;
import com.fryzjerappbackend.service.ServiceService;
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

public class ServiceControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ServiceController serviceController;

    @Mock
    private ServiceService serviceService;

    @Before
    public void setUpMocks() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(serviceController).setHandlerExceptionResolvers().build();
    }

    @Test
    public void shouldSuccessfullyCreateService() throws Exception {
        //given
        Appointment appointment = new Appointment();

        //then
        post(mockMvc, "/service/create", appointment).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldReturnAllServices() throws Exception {
        //given
        Service service = new Service();
        service.setName("testName");

        //when
        Mockito.when(serviceService.getAllServices()).thenReturn((Collections.singletonList(service)));

        //then
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/service/get");

        //then
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.[0].name", is(equalTo(service.getName()))))
                .andDo(MockMvcResultHandlers.print());
    }
}
