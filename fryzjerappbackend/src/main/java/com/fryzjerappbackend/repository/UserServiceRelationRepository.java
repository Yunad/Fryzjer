package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.UserServiceRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRelationRepository extends JpaRepository<UserServiceRelation, Long> {
}
