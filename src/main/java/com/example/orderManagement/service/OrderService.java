package com.example.orderManagement.service;

import com.example.orderManagement.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(int id);
    void deleteOrderById(int id);
    OrderDto updateOrder(OrderDto orderDto, int id);
}

