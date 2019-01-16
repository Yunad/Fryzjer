package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.UserServiceRelation;
import com.fryzjerappbackend.repository.UserAppoinmentServiceRepository;
import com.fryzjerappbackend.repository.UserServiceRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceRelationService {
    private UserServiceRelationRepository userAppoinmentServiceRepository;

    @Autowired
    public UserServiceRelationService(UserServiceRelationRepository userAppoinmentServiceRepository) {
        this.userAppoinmentServiceRepository = userAppoinmentServiceRepository;
    }

    public List<UserServiceRelation> getAllUserServiceRelations() {
        return userAppoinmentServiceRepository.findAll();
    }

    public void createUserServiceRelations(UserServiceRelation userServiceRelation) {
        userAppoinmentServiceRepository.save(userServiceRelation);
    }
}

