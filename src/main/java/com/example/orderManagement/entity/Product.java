package com.example.orderManagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private int id;
    private String slug;
    private String name;
    private String reference;
    private double price;
    private double vat;
    private boolean stokable;

}
