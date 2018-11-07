package com;

import com.fryzjerappbackend.Client;
import com.fryzjerappbackend.ClientRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class FryzjerappbackendApplication implements ApplicationRunner {

    private final ClientRepository clientRepository;

    public FryzjerappbackendApplication(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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

//        clientRepository.deleteById(managedClient.getId());

        final int thirdSize = clientRepository.findAll().size();
        System.out.println("thirdSize = " + thirdSize);

    }
}
