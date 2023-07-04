package com.example.orderManagement.service.impl;

import com.example.orderManagement.dto.StockDto;
import com.example.orderManagement.entity.Product;
import com.example.orderManagement.entity.Stock;
import com.example.orderManagement.exception.ResourceNotFoundException;
import com.example.orderManagement.repository.StockRepository;
import com.example.orderManagement.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public StockDto createStock(StockDto stockDto) {
        Stock stock = mapToEntity(stockDto);
        Stock newStock = stockRepository.save(stock);
        return mapToDTO(newStock);
    }

    @Override
    public List<StockDto> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public StockDto getStockById(int id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));
        return mapToDTO(stock);
    }

    @Override
    public void deleteStockById(int id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));
        stockRepository.delete(stock);
    }

    @Override
    public StockDto updateStock(StockDto stockDto, int id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));

        // Update the properties of the stock entity using stockDto

        Stock updatedStock = stockRepository.save(stock);
        return mapToDTO(updatedStock);
    }

    private Stock mapToEntity(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setId(stockDto.getId());
        stock.setQuantity(stockDto.getQuantity());
        stock.setUpdatedAt(stockDto.getUpdatedAt());

        Product product = new Product();
        product.setId(stockDto.getProductId());
        stock.setProduct(product);
        return stock;
    }

    private StockDto mapToDTO(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setQuantity(stock.getQuantity());
        stockDto.setUpdatedAt(stock.getUpdatedAt());

        int productId = stock.getProduct().getId();
        stockDto.setProductId(productId);
        
        return stockDto;
    }
}
