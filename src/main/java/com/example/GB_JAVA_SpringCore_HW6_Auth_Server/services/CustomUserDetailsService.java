package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.services;

import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.models.User;
import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private RoleService roleService;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
                );
    }

    public void createNewUser(User user) {
        user.setRoles(roleService.getRolesForUser(Set.of("ROLE_USER")));
        userRepository.save(user);
    }

    public void createNewUser(User user, Set<String> roles) {
        user.setRoles(roleService.getRolesForUser(roles));
        userRepository.save(user);
    }
}
