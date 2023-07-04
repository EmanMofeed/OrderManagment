package com.example.orderManagement.service;

import com.example.orderManagement.dto.ProductOrderDto;

import java.util.List;

public interface ProductOrderService {
    ProductOrderDto createProductOrder(ProductOrderDto productOrderDto);
    List<ProductOrderDto> getAllProductOrders();
    ProductOrderDto getProductOrderById(int id);
    void deleteProductOrderById(int id);
    ProductOrderDto updateProductOrder(ProductOrderDto productOrderDto, int id);
}

