package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
