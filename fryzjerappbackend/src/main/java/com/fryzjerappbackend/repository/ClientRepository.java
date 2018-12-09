package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Override
    <S extends Client> S save(S s);

    @Override
    void delete(Client client);

    @Override
    <S extends Client> S saveAndFlush(S s);

    @Override
    <S extends Client> Optional<S> findOne(Example<S> example);
}
