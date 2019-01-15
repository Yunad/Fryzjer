package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.UserServiceRelation;
import com.fryzjerappbackend.service.UserServiceRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relation")
public class UserServiceRelationController {

    @Autowired
    private UserServiceRelationService userServiceRelationService;


    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<UserServiceRelation> getAllUsersServices() {
        return userServiceRelationService.getAllUserServiceRelations();
    }

    @PostMapping("/create/user-service")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserService(@RequestBody UserServiceRelation userServiceRelation) {
        userServiceRelationService.createUserServiceRelations(userServiceRelation);

    }
}
