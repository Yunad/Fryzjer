package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
