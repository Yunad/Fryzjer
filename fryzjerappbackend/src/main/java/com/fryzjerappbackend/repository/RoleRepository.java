package com.fryzjerappbackend.repository;

import com.fryzjerappbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
