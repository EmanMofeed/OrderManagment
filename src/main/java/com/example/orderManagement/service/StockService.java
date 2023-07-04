package com.example.orderManagement.service;

import com.example.orderManagement.dto.StockDto;

import java.util.List;

public interface StockService {
    StockDto createStock(StockDto stockDto);
    List<StockDto> getAllStocks();
    StockDto getStockById(int id);
    void deleteStockById(int id);
    StockDto updateStock(StockDto stockDto, int id);
}

