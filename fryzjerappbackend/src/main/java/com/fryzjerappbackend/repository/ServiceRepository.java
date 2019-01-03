package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
