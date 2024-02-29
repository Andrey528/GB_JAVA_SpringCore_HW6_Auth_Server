package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.dtos;

import lombok.Data;

@Data
public class JwtRequest {
    private  String  username;
    private String password;
}
