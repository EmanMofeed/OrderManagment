package com.example.orderManagement.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ProductOrder {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private int quantity;
    private double price;
    private double vat;

}

