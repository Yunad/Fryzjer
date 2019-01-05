package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

@SpringBootTest
@DataJpaTest
@AutoConfigureTestEntityManager
@AutoConfigureDataJpa
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleControllerTest extends AbstractTransactionalTestNGSpringContextTests {
    private static final Logger LOG = LogManager.getLogger(RoleControllerTest.class);
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private final String USERNAME = "name";

    @BeforeMethod
    public void testInit() {
        entityManager.persist(new Role(1L,"Pracownik"));
        entityManager.persist(new User("name", "lastName", "password", "email", 1L));
    }

    @Test
    public void userCreation() {
        Optional<User> user = userRepository.findByName(USERNAME);
        LOG.info("User from database = {}", user);
        if (user.isPresent()) {
            final User user1 = user.get();
            Assert.assertEquals(user1.getName(), "name");
            Assert.assertEquals(user1.getEmail(), "email");
            Assert.assertEquals(user1.getLastName(), "lastName");
            Assert.assertEquals(user1.getPassword(), "password");
            Assert.assertEquals(user1.getRoleId().compareTo(1L), 0);
        }
    }

    @Test
    public void userDeletion() {
        Optional<User> user = userRepository.findByName(USERNAME);
        if (user.isPresent())
            entityManager.remove(user.get());
        Assert.assertFalse(userRepository.findUserById(user.get().getId()).isPresent());
    }

    @Test
    public void userUpdate() {
        Optional<User> user = userRepository.findByName(USERNAME);
        Optional<User> updatedUser;
        LOG.info("user in database {}", user);

        if (user.isPresent()) {
            user.get().setName("name2");
        }
        updatedUser = userRepository.findUserById(user.get().getId());

        if (updatedUser.isPresent()) {
            Assert.assertEquals(updatedUser.get().getName(), "name2", "User has not been updated");
            LOG.info("user in database {}", updatedUser);
        }

    }
}