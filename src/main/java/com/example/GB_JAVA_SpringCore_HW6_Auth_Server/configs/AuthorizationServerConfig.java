package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.configs;

import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.services.CustomUserDetailsService;
import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.services.JpaRegisteredClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
@Import(OAuth2AuthorizationServerAutoConfiguration.class)
//@EnableJpaRepositories(basePackageClasses = com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories.RegisteredClientRepository.class)
public class AuthorizationServerConfig {
    @Autowired
    private CustomUserDetailsService userDetailsService;

//    private RegisteredClientRepository registeredClientRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/secured", "/info").authenticated();
                        }
                )
                        .build();
    }

    // для аутентификации пользователей
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    // для шифрования паролей
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // возвращает менеджер аутентификации, используя конфигурацию аутентификации
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // создает репозиторий зарегистрированных клиентов
//    @Bean
//    public JpaRegisteredClientRepository registeredClientRepository() {
//        return new JpaRegisteredClientRepository();
//    }
}
