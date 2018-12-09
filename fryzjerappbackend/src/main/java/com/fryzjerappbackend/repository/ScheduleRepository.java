package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Override
    List<Schedule> findAll();

    @Override
    <S extends Schedule> S saveAndFlush(S s);

    @Override
    void delete(Schedule schedule);
}
