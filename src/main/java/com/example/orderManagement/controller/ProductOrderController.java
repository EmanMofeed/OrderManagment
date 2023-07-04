package com.example.orderManagement.controller;

import com.example.orderManagement.dto.ProductOrderDto;
import com.example.orderManagement.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping
    public ResponseEntity<ProductOrderDto> createProductOrder(@RequestBody ProductOrderDto productOrderDto) {
        ProductOrderDto createdProductOrder = productOrderService.createProductOrder(productOrderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductOrder);
    }

    @GetMapping
    public ResponseEntity<List<ProductOrderDto>> getAllProductOrders() {
        List<ProductOrderDto> productOrders = productOrderService.getAllProductOrders();
        return ResponseEntity.ok(productOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOrderDto> getProductOrderById(@PathVariable int id) {
        ProductOrderDto productOrder = productOrderService.getProductOrderById(id);
        return ResponseEntity.ok(productOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductOrderById(@PathVariable int id) {
        productOrderService.deleteProductOrderById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOrderDto> updateProductOrder(@RequestBody ProductOrderDto productOrderDto, @PathVariable int id) {
        ProductOrderDto updatedProductOrder = productOrderService.updateProductOrder(productOrderDto, id);
        return new ResponseEntity<>(updatedProductOrder, HttpStatus.OK);
    }
}

