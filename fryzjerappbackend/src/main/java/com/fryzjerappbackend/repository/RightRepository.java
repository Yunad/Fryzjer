package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Rights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RightRepository extends JpaRepository<Rights, Long> {
}
