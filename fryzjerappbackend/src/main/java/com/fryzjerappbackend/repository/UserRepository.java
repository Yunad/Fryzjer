package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Client, Long> {
}
