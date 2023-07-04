package com.example.orderManagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StockDto {
    private int id;
    private int productId;
    private int quantity;
    private LocalDateTime updatedAt;

}

