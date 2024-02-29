package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
}
