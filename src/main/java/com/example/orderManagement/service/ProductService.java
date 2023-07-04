package com.example.orderManagement.service;

import com.example.orderManagement.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(int id);
    void deleteProductById(int id);
    ProductDto updateProduct(ProductDto productDto, int id);
}

