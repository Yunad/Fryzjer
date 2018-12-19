package com;

import com.fryzjerappbackend.model.User;
import com.fryzjerappbackend.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class FryzjerappbackendApplication implements ApplicationRunner {

    private static final Logger LOG = LogManager.getLogger(FryzjerappbackendApplication.class);

    private final UserRepository userRepository;
    private final WorkerRepository workerRepository;
    private final ReservationRepository reservationRepository;
    private final ScheduleRepository scheduleRepository;
    private final ServiceRepository serviceRepository;
    private final RightRepository rightRepository;

    public FryzjerappbackendApplication(UserRepository userRepository, WorkerRepository workerRepository, ReservationRepository reservationRepository, ScheduleRepository scheduleRepository, ServiceRepository serviceRepository, RightRepository rightRepository) {
        this.userRepository = userRepository;
        this.workerRepository = workerRepository;
        this.reservationRepository = reservationRepository;
        this.scheduleRepository = scheduleRepository;
        this.serviceRepository = serviceRepository;
        this.rightRepository = rightRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FryzjerappbackendApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final int firstSize = userRepository.findAll().size();
        LOG.info("Size of database= {}", firstSize);

        final User newUser = new User("Uzytkownik1", "Nazwisko2", "Haslo3", "email@email.email");

        final User managedUser = userRepository.save(newUser); // managed by JPA

        LOG.info("Managed User = {}", managedUser);

        final int secondSize = userRepository.findAll().size();

        LOG.info("secondSize = {}", secondSize);

        final Optional<User> foundClient = userRepository.findById(managedUser.getId());

        LOG.info("foundClient = {}", foundClient);

//        clientRepository.deleteById(managedUser.getId());

        final int thirdSize = userRepository.findAll().size();
        LOG.info("third Size = {}", thirdSize);

    }
}
