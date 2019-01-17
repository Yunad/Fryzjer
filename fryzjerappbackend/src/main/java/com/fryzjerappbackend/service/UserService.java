package com.fryzjerappbackend.service;

import com.auth.validator.UserValidator;
import com.fryzjerappbackend.exception.CustomError;
import com.fryzjerappbackend.exception.EmailExistsException;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CustomError customError;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isUserExistInDatabase(String email) {
        final Optional<User> byEmail = userRepository.findByEmail(email);
        return byEmail.isPresent();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    public void registerNewUserAccount(User user) throws EmailExistsException {
        User dbUser = new User();
        if (!isUserExistInDatabase(user.getEmail())) {
            dbUser.setEmail(user.getEmail());
            userValidator.validate(user, customError);
            dbUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            dbUser.setName(user.getName());
            dbUser.setLastName(user.getLastName());
            dbUser.setRoleId(2L);
            userRepository.save(dbUser);
        }
    }

    public List<User> getUserByRoleId(Long id) {
        return userRepository.findUserByRoleId(id);
    }
}

