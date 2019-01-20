package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static com.fryzjerappbackend.controler.ControllerTestHelper.post;

public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private User user;

    @Before
    public void setUpMocks() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).setHandlerExceptionResolvers().build();

        user = new User();
        user.setName("test");
        user.setEmail("email@femail");
        Mockito.when(userService.getUserById(user.getId())).thenReturn(Optional.of(user));
    }

    @Test
    public void shouldSuccessfullyCreateUser() throws Exception {
        //given
        User user = new User();
        user.setEmail("e@mail.pl");
        user.setName("Name");
        user.setLastName("LName");
        user.setPassword("password");
        user.setRoleId(1L);

        //then
        post(mockMvc, "/user/create", user).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldFailCreatingUserWithMissingMail() throws Exception {
        //given
        User user = new User();
        user.setName("Name");
        user.setLastName("LName");
        user.setPassword("password");
        user.setRoleId(1L);

        //then
        post(mockMvc, "/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithMissingName() throws Exception {
        //given
        User user = new User();
        user.setEmail("e@mail.pl");
        user.setLastName("LName");
        user.setPassword("password");
        user.setRoleId(1L);

        //then
        post(mockMvc, "/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithMissingLastName() throws Exception {
        //given
        User user = new User();
        user.setEmail("e@mail.pl");
        user.setName("Name");
        user.setPassword("password");
        user.setRoleId(1L);

        //then
        post(mockMvc, "/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithMissingPassword() throws Exception {
        //given
        User user = new User();
        user.setEmail("e@mail.pl");
        user.setName("Name");
        user.setLastName("LName");
        user.setRoleId(1L);

        //then
        post(mockMvc, "/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithMissingRoleID() throws Exception {
        //given
        User user = new User();
        user.setEmail("e@mail.pl");
        user.setName("Name");
        user.setLastName("LName");
        user.setPassword("password");

        //then
        post(mockMvc, "/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
