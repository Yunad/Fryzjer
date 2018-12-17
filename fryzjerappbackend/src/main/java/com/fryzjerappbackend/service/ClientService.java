package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Client;
import com.fryzjerappbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.getOne(id);
    }

    public Optional<Client> findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.getOne(id);
        if (client != null) {
            clientRepository.deleteById(id);
        }
    }

    public boolean isUserInDatabase(String email) {
        Optional<Client> client = clientRepository.findByEmail(email);
        return client.isPresent();
    }
}
