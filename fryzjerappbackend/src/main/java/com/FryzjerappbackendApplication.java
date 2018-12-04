package com;

import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class FryzjerappbackendApplication implements ApplicationRunner {

    private final UserRepository userRepository;

    //
    public FryzjerappbackendApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FryzjerappbackendApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final int firstSize = userRepository.findAll().size();
        System.out.println("firstSize = " + firstSize);

        final User newUser = new User("name1", "name2", "pass1", "email1");

        final User managedUser = userRepository.save(newUser); // managed by JPA

        System.out.println("managedUser = " + managedUser);

        final int secondSize = userRepository.findAll().size();
        System.out.println("secondSize = " + secondSize);

        final Optional<User> foundClient = userRepository.findById(managedUser.getId());

        System.out.println("foundClient = " + foundClient);

        userRepository.deleteById(managedUser.getId());

        final int thirdSize = userRepository.findAll().size();
        System.out.println("thirdSize = " + thirdSize);

    }
}
