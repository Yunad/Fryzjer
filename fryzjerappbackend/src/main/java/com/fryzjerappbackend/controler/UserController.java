package com.fryzjerappbackend.controler;


//import com.auth.validator.UserValidator;

import com.fryzjerappbackend.exception.EmailExistsException;
import com.fryzjerappbackend.exception.UserNotFoundException;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.service.UserService;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserValidator userValidator;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        final Optional<User> userById = userService.getUserById(id);
        if (!userById.isPresent()) {
            throw new UserNotFoundException("id- " + id);
        }
        return userService.getUserById(id);
    }

    @GetMapping("/get/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserByEmail(@PathVariable("email") String email) {
        final Optional<User> userByEmail = userService.getUserByEmail(email);
        if (!userByEmail.isPresent()) {
            throw new UserNotFoundException("Email " + email);
        }
        return userService.getUserByEmail(email);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //TODO other way to handle mapings
//    @GetMapping(path = "/user/get/all")
//    public ResponseEntity<List<User>> listUser() {
//        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
//    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user) {
        try {
            userService.registerNewUserAccount(user);
        } catch (EmailExistsException e) {
            LOG.warn(e);
        }
        LOG.info("User {} has been created.", user);
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

//    @PostMapping("/login")
//    public ResponseEntity<String> loginEndpoint(String email, String password) {
//        final Optional<User> userByEmail = userService.getUserByEmail(email);
//        if (userByEmail.isPresent()) {
//
//        }
//        return new ResponseEntity<>("Logged in", HttpStatus.OK);
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        Optional<User> user = userService.getUserByEmail(email);

        if (!user.isPresent()) {
            throw new ServletException("User email not found.");
        }

        String pwd = user.get().getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }
}