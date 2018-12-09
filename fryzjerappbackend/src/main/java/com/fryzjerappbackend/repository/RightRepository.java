package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Right;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RightRepository extends JpaRepository<Right, Long> {
    @Override
    List<Right> findAll();

    @Override
    <S extends Right> S saveAndFlush(S s);

    @Override
    void delete(Right right);
}
