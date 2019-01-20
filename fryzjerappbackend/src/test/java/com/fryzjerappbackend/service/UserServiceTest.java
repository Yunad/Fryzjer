package com.fryzjerappbackend.service;

import com.fryzjerappbackend.exception.EmailExistsException;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private User createUserObject() {
        User user = new User();
        user.setName("Name");
        user.setEmail("e@mail.com");
        user.setLastName("LName");
        user.setPassword("$2a$10$ehaRlaIE2/awIoVf.B2BLOqBn9EuMx4iZ/zF727Hx3LVWP3oc33n2");
        user.setRoleId(1L);
        return user;
    }

    @Test
    public void shouldGetAllUsers() {
        //given
        List<User> userList = new ArrayList<>();
        userList.add(createUserObject());
        userList.add(createUserObject());

        //when
        when(userRepository.findAll()).thenReturn(userList);

        //then
        List<User> result = userService.getAllUsers();

        verify(userRepository, times(1)).findAll();
        assertEquals(2, result.size());
        assertEquals(userList.size(), result.size());
    }

//    @Test
//    public void shouldFindUserByEmail() {
//        //given
//        User testObj = createUserObject();
//
//        //when
//        when(userRepository.findByEmail(testObj.getEmail())).thenReturn(Optional.of(testObj));
//
//        //then
//        Optional<User> result = userService.isUserExistInDatabase(testObj.getEmail());
//
//        verify(userRepository, times(1)).findByEmail(testObj.getEmail());
//        assertTrue(result.isPresent());
//        assertEquals(result.get().getEmail(), testObj.getEmail());
//    }
//
//    @Test
//    public void shouldNotFindUserByEmail() {
//        //given
//        User testObj = createUserObject();
//
//        //then
//        Optional<User> result = userService.isUserExistInDatabase(testObj.getEmail());
//
//        verify(userRepository, times(1)).findByEmail(testObj.getEmail());
//        assertFalse(result.isPresent());
//    }

    @Test
    public void shouldFindUserById() {
        //given
        User testObj = createUserObject();

        //when
        when(userRepository.findUserById(testObj.getId())).thenReturn(Optional.of(testObj));

        //then
        Optional<User> result = userService.getUserById(testObj.getId());

        verify(userRepository, times(1)).findUserById(testObj.getId());
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), testObj.getId());
    }

    @Test
    public void shouldNotFindUserById() {
        //given
        User testObj = createUserObject();

        //then
        Optional<User> result = userService.getUserById(testObj.getId());

        verify(userRepository, times(1)).findUserById(testObj.getId());
        assertFalse(result.isPresent());
    }
}
