package com.example.GB_JAVA_SpringCore_HW6_Auth_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.GB_JAVA_SpringCore_HW6_Auth_Server.repositories")
public class GbJavaSpringCoreHw6AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GbJavaSpringCoreHw6AuthServerApplication.class, args);
	}

}
