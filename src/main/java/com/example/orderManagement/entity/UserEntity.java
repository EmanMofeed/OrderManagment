package com.example.orderManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    // Constructors, getters, and setters
}
