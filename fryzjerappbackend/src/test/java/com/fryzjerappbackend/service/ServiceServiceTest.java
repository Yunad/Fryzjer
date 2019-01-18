package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Service;
import com.fryzjerappbackend.repository.ServiceRepository;
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
public class ServiceServiceTest {

    @MockBean
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceService serivceService;

    @Test
    public void shouldGetAllServices() {
        //given
        List<Service> roleList = new ArrayList<>();
        roleList.add(new Service());
        roleList.add(new Service());

        //when
        when(serviceRepository.findAll()).thenReturn(roleList);

        //then
        List<Service> result = serivceService.getAllServices();
        verify(serviceRepository, times(1)).findAll();
        assertEquals(result.size(), 2);
        assertEquals(result.size(), roleList.size());
    }

    @Test
    public void shouldCreateService() {
        //given
        Service service = new Service();

        //when

        //then
        serivceService.createService(service);
        verify(serviceRepository, times(1)).save(service);
    }
}
