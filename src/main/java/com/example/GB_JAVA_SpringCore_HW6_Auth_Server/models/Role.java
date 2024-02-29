package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", unique = true, nullable = false)
    private String name;
}
