package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
