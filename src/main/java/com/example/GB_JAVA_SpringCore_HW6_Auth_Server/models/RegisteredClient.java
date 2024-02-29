package com.example.GB_JAVA_SpringCore_HW6_Auth_Server.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="registered_clients")
public class RegisteredClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="client_id", nullable = false, unique = true)
    private String clientId;

    @Column(name="client_secret", nullable = false)
    private String clientSecret;

    @Column(name="redirect_uri", nullable = false)
    private String redirectUri;

    @Column(name="scope", nullable = false)
    private String scope;

    @Column(name="authorized_grant_types", nullable = false)
    private String authorizedGrantTypes;

    @Column(name="authorities", nullable = false)
    private String authorities;

    @Column(name="access_token_validity_seconds", nullable = false)
    private Integer accessTokenValiditySeconds;

    @Column(name="refresh_token_validity_seconds", nullable = false)
    private Integer refreshTokenValiditySeconds;
}
