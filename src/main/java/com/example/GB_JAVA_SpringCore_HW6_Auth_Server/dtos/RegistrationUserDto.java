package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.dtos;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String confirmPassword;

    private String email;
}
