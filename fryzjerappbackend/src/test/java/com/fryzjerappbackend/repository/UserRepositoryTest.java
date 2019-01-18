package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User createUser(String name, String lastName, String email, String password, long roleId) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleId(roleId);
        return user;
    }

    @Test
    public void shouldFindUserByName() {
        //given
        User user = createUser("name", "lastName", "em@ail", "password", 1);

        userRepository.save(user);
        //when

        //then;
        Optional<User> result = userRepository.findByName(user.getName());
        assertTrue(result.isPresent());
        assertEquals(result.get().getName(), user.getName());
        assertEquals(result.get().getLastName(), user.getLastName());
        assertEquals(result.get().getEmail(), user.getEmail());
        assertEquals(result.get().getPassword(), user.getPassword());
        assertEquals(result.get().getRoleId(), user.getRoleId());
        assertNotNull(user.getRoleId());
    }

    @Test
    public void shouldFindUserByMail() {
        //given
        User user = createUser("name", "lastName", "em@ail", "password", 1);

        userRepository.save(user);
        //when

        //then;
        Optional<User> result = userRepository.findByEmail(user.getEmail());
        assertTrue(result.isPresent());
        assertEquals(result.get().getName(), user.getName());
        assertEquals(result.get().getLastName(), user.getLastName());
        assertEquals(result.get().getEmail(), user.getEmail());
        assertEquals(result.get().getPassword(), user.getPassword());
        assertEquals(result.get().getRoleId(), user.getRoleId());
        assertNotNull(user.getRoleId());
    }

    @Test
    public void shouldFindUserById() {
        //given
        User user = createUser("name", "lastName", "em@ail", "password", 1);

        User save = userRepository.save(user);
        //when

        //then;
        Optional<User> result = userRepository.findUserById(save.getId());
        assertTrue(result.isPresent());
        assertEquals(result.get().getName(), user.getName());
        assertEquals(result.get().getLastName(), user.getLastName());
        assertEquals(result.get().getEmail(), user.getEmail());
        assertEquals(result.get().getPassword(), user.getPassword());
        assertEquals(result.get().getRoleId(), user.getRoleId());
        assertNotNull(user.getRoleId());
    }

    @Test
    public void shouldFindAllUsers() {
        //given
        User user = createUser("name", "lastName", "em@ail", "password", 1);
        User user2 = createUser("name2", "lastName2", "em@ail2", "password2", 2);

        userRepository.save(user);
        userRepository.save(user2);
        //when

        //then;
        List<User> userList = userRepository.findAll();
        assertFalse(userList.isEmpty());
        assertEquals(2, userList.size());
        assertTrue(userList.stream().allMatch(u -> u.getId() != null));
    }
}
