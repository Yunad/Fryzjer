package com;

import com.fryzjerappbackend.model.Client;
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

    private final ClientRepository clientRepository;
    private final WorkerRepository workerRepository;
    private final ReservationRepository reservationRepository;
    private final ScheduleRepository scheduleRepository;
    private final ServiceRepository serviceRepository;
    private final RightRepository rightRepository;

    public FryzjerappbackendApplication(ClientRepository clientRepository, WorkerRepository workerRepository, ReservationRepository reservationRepository, ScheduleRepository scheduleRepository, ServiceRepository serviceRepository, RightRepository rightRepository) {
        this.clientRepository = clientRepository;
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
        final int firstSize = clientRepository.findAll().size();
        LOG.info("Size of database= {}", firstSize);

        final Client newClient = new Client("Uzytkownik1", "Nazwisko2", "Haslo3", "email@email.email");

        final Client managedClient = clientRepository.save(newClient); // managed by JPA

        LOG.info("Managed Client = {}", managedClient);

        final int secondSize = clientRepository.findAll().size();

        LOG.info("secondSize = {}", secondSize);

        final Optional<Client> foundClient = clientRepository.findById(managedClient.getId());

        LOG.info("foundClient = {}", foundClient);

//        clientRepository.deleteById(managedClient.getId());

        final int thirdSize = clientRepository.findAll().size();
        LOG.info("third Size = {}", thirdSize);

    }
}
