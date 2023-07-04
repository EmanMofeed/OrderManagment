package com.example.orderManagement.service.impl;

import com.example.orderManagement.dto.ProductDto;
import com.example.orderManagement.entity.Product;
import com.example.orderManagement.exception.ResourceNotFoundException;
import com.example.orderManagement.repository.ProductRepository;
import com.example.orderManagement.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Product newProduct = productRepository.save(product);
        return mapToDTO(newProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapToDTO(product);
    }

    @Override
    public void deleteProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        // Update the properties of the product entity using productDto

        Product updatedProduct = productRepository.save(product);
        return mapToDTO(updatedProduct);
    }

    private Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setVat(productDto.getVat());
        product.setStokable(productDto.isStokable());
        return product;
    }

    private ProductDto mapToDTO(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setStokable(product.isStokable());
        productDto.setPrice(product.getPrice());
        productDto.setName(product.getName());
        productDto.setReference(product.getReference());
        productDto.setSlug(product.getSlug());
        productDto.setVat(product.getVat());
        return productDto;
    }
}

