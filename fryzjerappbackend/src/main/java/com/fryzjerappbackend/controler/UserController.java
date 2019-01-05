package com.fryzjerappbackend.controler;


import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/get/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> findByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        LOG.info("User {} has been created.", user);
        userService.createUser(user);
    }
}