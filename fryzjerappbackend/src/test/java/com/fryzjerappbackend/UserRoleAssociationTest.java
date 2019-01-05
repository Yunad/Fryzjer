package com.fryzjerappbackend;

import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.RoleRepository;
import com.fryzjerappbackend.repository.UserRepository;
import com.fryzjerappbackend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;


@SpringBootTest
@DataJpaTest
@AutoConfigureTestEntityManager
@AutoConfigureDataJpa
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRoleAssociationTest extends AbstractTransactionalTestNGSpringContextTests {
    private static final Logger LOG = LogManager.getLogger(UserRoleAssociationTest.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeMethod
    public void testInit() {
        entityManager.persist(new Role((long) 1, "roleName"));
        entityManager.persist(new User("name", "lastName", "password", "email", 1L));
    }

    @Test //FIXME get association working for tests.
    public void checkAssociation() {
        final Optional<User> user = userRepository.findByName("name");
        LOG.info(user);
        final List<Role> all = roleRepository.findAll();
        LOG.info(all);
    }

}
