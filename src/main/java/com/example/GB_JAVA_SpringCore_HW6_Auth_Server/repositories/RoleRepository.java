package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories;

import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
