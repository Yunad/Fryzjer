package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findUserByName(String name);

    Optional<User> findByName(String name);

    Optional<User> findUserByUserId(Long userId);
}
