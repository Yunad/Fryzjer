package com;

import com.fryzjerappbackend.model.Client;
import com.fryzjerappbackend.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class FryzjerappbackendApplication implements ApplicationRunner {
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
        System.out.println("firstSize = " + firstSize);

        final Client newClient = new Client("name1", "name2", "pass1", "email1");

        final Client managedClient = clientRepository.save(newClient); // managed by JPA

        System.out.println("managedClient = " + managedClient);

        final int secondSize = clientRepository.findAll().size();
        System.out.println("secondSize = " + secondSize);

        final Optional<Client> foundClient = clientRepository.findById(managedClient.getId());

        System.out.println("foundClient = " + foundClient);

        clientRepository.deleteById(managedClient.getId());

        final int thirdSize = clientRepository.findAll().size();
        System.out.println("thirdSize = " + thirdSize);

    }
}
