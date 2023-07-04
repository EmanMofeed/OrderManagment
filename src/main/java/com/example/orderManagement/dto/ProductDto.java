package com.example.orderManagement.dto;


import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String slug;
    private String name;
    private String reference;
    private double price;
    private double vat;
    private boolean stokable;

}

