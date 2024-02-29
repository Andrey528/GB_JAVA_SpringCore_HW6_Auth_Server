package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.services;

import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.models.Role;
import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Set<Role> getRolesForUser(Set<String> roles) {
        Set<Role> rolesFromDb = new HashSet<>();

        roles.forEach(role -> rolesFromDb.add(roleRepository.findByName(role).get()));

        return rolesFromDb;
    }
}
