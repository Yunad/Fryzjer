package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.RoleRepository;
import com.fryzjerappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public User getUserById(Long id) {
//        return userRepository.getOne(id);
//    }
//
//    public Optional<User> findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public void saveUser(User user){
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Role role = roleRepository.findByRole("Klient");
//    }
//
//    public User updateUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(Long id) {
//        User user = userRepository.getOne(id);
//        if (user != null) {
//            userRepository.deleteById(id);
//        }
//    }
//
//    public boolean isUserInDatabase(String email) {
//        Optional<User> client = userRepository.findByEmail(email);
//        return client.isPresent();
//    }

}
