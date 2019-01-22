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

import java.util.Collections;

import static com.fryzjerappbackend.controler.ControllerTestHelper.post;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class AppointmentControllerTest {

    private MockMvc mockMvc; //mockuje request i responsy, dobra do testow kontrolerow
//@Marcin Marcin ja mam nadzieje,ze ty pamietasz ze twoim zadaniem nie bylo klepanie dalej testów, a polaczenia modolow logowania oraz w zaleznosci od autentykacji zastosowanie zmian na main page? opisanie sobie wszystkiego ci nie pomoze, tym barrdziej ze jasno miales powiedziane nie przez nas jaki masz cel. Nie ma nic gorszego niz osoba w zespole ktora NIE SLUCHA ewentualnie nie jest w stanie obronic swojej propozycji. 
    @InjectMocks //adnotacja kolekcjonuje wszystkie nocki
    private AppointmentController appointmentController;

    @Mock //tworzy udawane beany - kontenerki by spring zwrocil nie null a obiekt
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
        //metoda Mockito - sprawdzamy czy obiekt wyjety po naszej logice jest dalej tym samym
        Mockito.when(appointmentService.getAllAppointments()).thenReturn((Collections.singletonList(appointment)));

        //then
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/appointment/get");

        //then
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk()) //andExpect to jak assert w unitach
                .andExpect(jsonPath("$.[0].date", is(equalTo(appointment.getDate()))))
                .andDo(MockMvcResultHandlers.print());
    }
}
