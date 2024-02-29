package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.dao;

import com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseInitializer {
    private final UserRepository userRepository;

    @Autowired
    public DatabaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initData() {
        if (userRepository.count() == 0) {
            ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
            databasePopulator.addScript(new ClassPathResource("db/migration/Init.sql"));

            DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        }
    }

    @Autowired
    private DataSource dataSource;
}
