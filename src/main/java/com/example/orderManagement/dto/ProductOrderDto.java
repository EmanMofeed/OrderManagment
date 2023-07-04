package com.example.orderManagement.dto;


import lombok.Data;

@Data
public class ProductOrderDto {
    private int id;
    private int productId;
    private int orderId;
    private int quantity;
    private double price;
    private double vat;

}

