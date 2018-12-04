package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
