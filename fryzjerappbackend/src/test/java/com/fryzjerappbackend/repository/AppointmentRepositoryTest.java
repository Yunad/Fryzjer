package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Appointment;
import com.fryzjerappbackend.model.Service;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.model.UserAppointment;
import com.fryzjerappbackend.service.ServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest //adnotacja zalatwia polaczenie do bazy
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) //czysci zawartosc po kazdej metodzie
//inaczej metody by wplywaly na drugie

public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    //wkladamy Appointment za pomoca beana i testujemy czy metoda zwroci to co napisalismy
    @Test
    public void shouldFindAppointmentById() {
        //given
        Appointment appointment = new Appointment();
        appointment.setDate("20190101");
        appointment.setServiceId(1L);

        User user = new User();
        user.setRoleId(1L);
        user.setPassword("Password1234");
        user.setEmail("email@o2.pl");
        user.setLastName("lname");
        user.setName("name");

        Service service = new Service();
        service.setDescription("desc");
        service.setDuration(1.0);
        service.setName("Name");
        service.setPrice(1.0);

        serviceRepository.save(service);
        userRepository.save(user);
        appointmentRepository.save(appointment);
        //when

        //then
        Optional<Appointment> result = appointmentRepository.findAppointmentById(appointment.getId());

        assertTrue(result.isPresent());
        assertEquals(result.get().getDate(), appointment.getDate());
        assertEquals(result.get().getServiceId(), appointment.getServiceId());
        assertNotNull(result.get().getId());
    }
}
