package com.example.orderManagement.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.Data;

import java.util.List;
@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private List<String> roles;

}
