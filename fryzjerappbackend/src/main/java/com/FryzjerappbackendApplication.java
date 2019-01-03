package com;

import com.fryzjerappbackend.repository.RoleRepository;
import com.fryzjerappbackend.repository.ServiceRepository;
import com.fryzjerappbackend.repository.UserRepository;
import com.fryzjerappbackend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FryzjerappbackendApplication implements ApplicationRunner {

    private static final Logger LOG = LogManager.getLogger(FryzjerappbackendApplication.class);

    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final RoleRepository roleRepository;

    public FryzjerappbackendApplication(UserRepository userRepository, ServiceRepository serviceRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FryzjerappbackendApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
