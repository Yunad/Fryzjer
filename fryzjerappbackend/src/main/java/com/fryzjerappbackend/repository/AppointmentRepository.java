package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
