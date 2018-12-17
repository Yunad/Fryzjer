package com.fryzjerappbackend.controler;


import com.fryzjerappbackend.model.Client;
import com.fryzjerappbackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientById(@PathVariable("id") long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/find/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> findByEmail(@PathVariable("email") String email) {
        return clientService.findClientByEmail(email);
    }

    @PostMapping("/create2")
    Client newClient(@RequestBody Client newClient) {
        return clientService.createClient(newClient);
    }

    @PostMapping("/create/")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createUser(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

}