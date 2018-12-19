package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RightRepository extends JpaRepository<Roles, Long> {
    @Override
    List<Roles> findAll();

    @Override
    <S extends Roles> S saveAndFlush(S s);

    @Override
    void delete(Roles roles);
}
