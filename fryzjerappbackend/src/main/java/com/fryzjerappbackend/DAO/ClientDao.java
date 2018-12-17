package com.fryzjerappbackend.DAO;

import com.fryzjerappbackend.model.Client;

import java.util.*;
import java.util.stream.Collectors;

public class ClientDao implements Dao<Client> {
    private List<Client> clientList = new ArrayList<>();

    @Override
    public Optional<Client> get(int id) {
        return Optional.ofNullable(clientList.get(id));
    }

    @Override
    public Collection<Client> getAll() {
        return clientList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public void update(Client client) {
        clientList.set(Math.toIntExact(client.getId()), client);
    }

    @Override
    public void delete(Client client) {
        clientList.set(Math.toIntExact(client.getId()), null);
    }
}
