package com.example.orderManagement.service.impl;

import com.example.orderManagement.dto.ProductOrderDto;
import com.example.orderManagement.entity.OrderEntity;
import com.example.orderManagement.entity.Product;
import com.example.orderManagement.entity.ProductOrder;
import com.example.orderManagement.exception.ResourceNotFoundException;
import com.example.orderManagement.repository.ProductOrderRepository;
import com.example.orderManagement.service.ProductOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public ProductOrderDto createProductOrder(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = mapToEntity(productOrderDto);
        ProductOrder newProductOrder = productOrderRepository.save(productOrder);
        return mapToDTO(newProductOrder);
    }

    @Override
    public List<ProductOrderDto> getAllProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAll();
        return productOrders.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductOrderDto getProductOrderById(int id) {
        ProductOrder productOrder = productOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductOrder", "id", id));
        return mapToDTO(productOrder);
    }

    @Override
    public void deleteProductOrderById(int id) {
        ProductOrder productOrder = productOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductOrder", "id", id));
        productOrderRepository.delete(productOrder);
    }

    @Override
    public ProductOrderDto updateProductOrder(ProductOrderDto productOrderDto, int id) {
        ProductOrder productOrder = productOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductOrder", "id", id));

        // Update the properties of the productOrder entity using productOrderDto

        ProductOrder updatedProductOrder = productOrderRepository.save(productOrder);
        return mapToDTO(updatedProductOrder);
    }

    private ProductOrder mapToEntity(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setId(productOrderDto.getId());
        productOrder.setPrice(productOrderDto.getPrice());
        productOrder.setQuantity(productOrderDto.getQuantity());
        productOrder.setVat(productOrderDto.getVat());

        // Retrieve and set the associated Product
        Product product = new Product();
        product.setId(productOrderDto.getProductId());
        productOrder.setProduct(product);

        // Retrieve and set the associated OrderEntity
        OrderEntity order = new OrderEntity();
        order.setId(productOrderDto.getOrderId());
        productOrder.setOrder(order);

        return productOrder;
    }

    private ProductOrderDto mapToDTO(ProductOrder productOrder) {
        ProductOrderDto productOrderDto = new ProductOrderDto();
        productOrderDto.setId(productOrder.getId());
        productOrderDto.setPrice(productOrder.getPrice());
        productOrderDto.setQuantity(productOrder.getQuantity());
        productOrderDto.setVat(productOrder.getVat());

        int productId = productOrder.getProduct().getId();
        productOrderDto.setProductId(productId);

        int orderId = productOrder.getOrder().getId();
        productOrderDto.setOrderId(orderId);
        return productOrderDto;
    }
}
