package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Service;
import com.fryzjerappbackend.model.UserServiceRelation;
import com.fryzjerappbackend.repository.UserServiceRelationRepository;
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
public class UserServiceRelationServiceTest {

    @MockBean
    private UserServiceRelationRepository userServiceRelationRepository;

    @Autowired
    private UserServiceRelationService userServiceRelationService;

    @Test
    public void shouldGetAllServices() {
        //given
        List<UserServiceRelation> userServiceRelations = new ArrayList<>();
        userServiceRelations.add(new UserServiceRelation());
        userServiceRelations.add(new UserServiceRelation());

        //when
        when(userServiceRelationRepository.findAll()).thenReturn(userServiceRelations);

        //then
        List<UserServiceRelation> result = userServiceRelationService.getAllUserServiceRelations();
        verify(userServiceRelationRepository, times(1)).findAll();
        assertEquals(result.size(), 2);
        assertEquals(result.size(), userServiceRelations.size());
    }

    @Test
    public void shouldCreateService() {
        //given
        UserServiceRelation service = new UserServiceRelation();

        //when

        //then
        userServiceRelationService.createUserServiceRelations(service);
        verify(userServiceRelationRepository, times(1)).save(service);
    }
}
