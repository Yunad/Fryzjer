package com.fryzjerappbackend.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fryzjerappbackend.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper OM = new ObjectMapper();

    @Test
    public void shouldSuccessfullyReturnListUsers() throws Exception {
        //given

        //when
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/get");

        //then
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldSuccessfullyCreateUser() throws Exception {
        //given
        User user = new User();
        user.setEmail("mail@mail.pl");
        user.setName("Imie");
        user.setLastName("Nazwisko");
        user.setPassword("haslohaslo");
        user.setRoleId(1L);

        //then
        post("/user/create", user).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldFailCreatingUserWithoutMail() throws Exception {
        //given
        User user = new User();
        user.setName("Imie");
        user.setLastName("Nazwisko");
        user.setPassword("haslohaslo");
        user.setRoleId(1L);

        //then
        post("/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithoutName() throws Exception {
        //given
        User user = new User();
        user.setEmail("mail@mail.pl");
        user.setLastName("Nazwisko");
        user.setPassword("haslohaslo");
        user.setRoleId(1L);

        //then
        post("/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithoutLastName() throws Exception {
        //given
        User user = new User();
        user.setEmail("mail@mail.pl");
        user.setName("Imie");
        user.setPassword("haslohaslo");
        user.setRoleId(1L);

        //then
        post("/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithoutPassword() throws Exception {
        //given
        User user = new User();
        user.setEmail("mail@mail.pl");
        user.setName("Imie");
        user.setLastName("Nazwisko");
        user.setRoleId(1L);

        //then
        post("/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldFailCreatingUserWithoutRoleID() throws Exception {
        //given
        User user = new User();
        user.setEmail("mail@mail.pl");
        user.setName("Imie");
        user.setLastName("Nazwisko");
        user.setPassword("haslohaslo");

        //then
        post("/user/create", user).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private ResultActions post(String path, User request) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(request)));
    }
}
