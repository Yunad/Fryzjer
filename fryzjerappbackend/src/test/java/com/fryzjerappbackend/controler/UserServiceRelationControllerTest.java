package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.UserServiceRelation;
import com.fryzjerappbackend.service.UserServiceRelationService;
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

public class UserServiceRelationControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserServiceRelationController userServiceRelationController;

    @Mock
    private UserServiceRelationService userServiceRelationService;

    @Before
    public void setUpMocks() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userServiceRelationController).setHandlerExceptionResolvers().build();
    }

    @Test
    public void shouldSuccessfullyCreateRelation() throws Exception {
        //given
        UserServiceRelation userServiceRelation = new UserServiceRelation();

        //then
        post(mockMvc, "/relation/create/user-service", userServiceRelation).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldReturnAllRelations() throws Exception {
        //given
        UserServiceRelation relation = new UserServiceRelation();
        relation.setServiceId(1L);
        relation.setUserId(1L);

        //when
        Mockito.when(userServiceRelationService.getAllUserServiceRelations()).thenReturn((Collections.singletonList(relation)));

        //then
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/relation/get");

        //then
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
