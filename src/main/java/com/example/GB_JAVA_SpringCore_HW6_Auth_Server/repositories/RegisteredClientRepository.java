package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories;

import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.models.RegisteredClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisteredClientRepository extends JpaRepository<RegisteredClient, Long> {
    Optional<RegisteredClient> findByClientId(String clientId);
}
