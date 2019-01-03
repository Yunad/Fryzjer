package com.fryzjerappbackend;

import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRoleAssociationTest extends AbstractTestNGSpringContextTests {
    private static final Logger LOG = LogManager.getLogger(UserRoleAssociationTest.class);

    @Autowired
    private UserService userService;


    @Test
    public void testing() {
        LOG.info("testinguberTesting {}", userService);
        Assert.assertNotNull(userService);
    }

    @Test
    public void checker() {
        User user = new User("test", "test", "test", "test");
        userService.createUser(user);
        final Optional<User> users = userService.findUserByEmail("test");
        LOG.info(users);
        Assert.assertTrue(users.isPresent());
    }

}
