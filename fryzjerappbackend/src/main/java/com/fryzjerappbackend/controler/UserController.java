package com.fryzjerappbackend.controler;


import com.auth.validator.UserValidator;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

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


    @GetMapping(path = "/user")
    public ResponseEntity<List<User>> listUser() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> listUser(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(userService.getAllUsers().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null), HttpStatus.OK);

    }

    @PostMapping(path = "/user")
    public ResponseEntity<String> listUser(@RequestBody User user) {
        return new ResponseEntity<>("18", HttpStatus.OK);
    }

    @GetMapping("/get/role/{roleId}")
    public List<User> findByRoleId(@PathVariable("roleId") Long id) {
        return userService.getUserByRoleId(id);
    }
}