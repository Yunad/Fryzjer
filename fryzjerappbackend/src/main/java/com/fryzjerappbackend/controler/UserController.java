package com.fryzjerappbackend.controler;


import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getClientById(@PathVariable("id") long id) {
        return userService.getClientById(id);
    }

    @GetMapping("/find/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> findByEmail(@PathVariable("email") String email) {
        return userService.findClientByEmail(email);
    }

    @PostMapping("/create2")
    User newClient(@RequestBody User newUser) {
        return userService.createClient(newUser);
    }

    @PostMapping("/create/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createClient(user);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllClients() {
        return userService.getAllClients();
    }

    @PostMapping("/login/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    public void loginUser(@PathVariable("email") String email,String Password){
        if(userService.isUserInDatabase(email)){

        }
    }
}