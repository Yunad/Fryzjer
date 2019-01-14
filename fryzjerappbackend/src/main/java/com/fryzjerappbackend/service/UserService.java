package com.fryzjerappbackend.service;

import com.fryzjerappbackend.exception.EmailExistsException;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    public void registerNewUserAccount(User webUser) throws EmailExistsException {
        final Optional<User> userByEmail = findUserByEmail(webUser.getEmail());
        if (userByEmail.isPresent()) {
            throw new EmailExistsException("There is an account with that email address:" + userByEmail);
        }
        User user = new User();
        user.setName(webUser.getName());
        user.setLastName(webUser.getName());
        user.setEmail(webUser.getEmail());
        user.setPassword(passwordEncoder.encode(webUser.getPassword()));
        user.setRoleId(2L);
        userRepository.save(user);
    }
}
