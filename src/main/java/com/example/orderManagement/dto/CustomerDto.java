package com.example.orderManagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate bornAt;

}

