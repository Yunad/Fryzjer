package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.UserAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppoinmentServiceRepository extends JpaRepository<UserAppointment, Long> {
}
