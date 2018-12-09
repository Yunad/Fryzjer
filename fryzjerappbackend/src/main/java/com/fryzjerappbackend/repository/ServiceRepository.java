package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Override
    List<Service> findAll();

    @Override
    <S extends Service> S saveAndFlush(S s);

    @Override
    void delete(Service service);
}
