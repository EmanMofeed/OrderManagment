package com.example.orderManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Customer {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate bornAt;

}
