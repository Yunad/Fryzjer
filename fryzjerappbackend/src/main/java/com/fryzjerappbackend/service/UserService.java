package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.getOne(id);
        if (user != null) {
            userRepository.deleteById(id);
        }
    }

    public boolean isUserInDatabase(String email) {
        Optional<User> client = userRepository.findByEmail(email);
        return client.isPresent();
    }
}
