package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Override
    List<Reservation> findAll();

    @Override
    <S extends Reservation> S saveAndFlush(S s);

    @Override
    Reservation getOne(Long aLong);
}
