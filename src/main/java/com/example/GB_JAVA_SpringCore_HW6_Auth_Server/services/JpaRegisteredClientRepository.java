package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.services;

import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.models.RegisteredClient;
import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories.RegisteredClientRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class JpaRegisteredClientRepository {
    @Autowired
    private RegisteredClientRepository registeredClientRepository;
}
