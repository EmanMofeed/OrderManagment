package com.example.orderManagement.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OrderDto {
    private int id;
    private int customerId;
    private LocalDateTime orderedAt;

}

