package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Override
    List<Worker> findAll();

    @Override
    <S extends Worker> S saveAndFlush(S s);

    @Override
    void delete(Worker worker);
}
