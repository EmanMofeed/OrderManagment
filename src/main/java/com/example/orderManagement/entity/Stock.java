package com.example.orderManagement.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Stock {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private LocalDateTime updatedAt;
}

