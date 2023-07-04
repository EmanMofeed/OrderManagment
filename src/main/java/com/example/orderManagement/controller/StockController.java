package com.example.orderManagement.controller;

import com.example.orderManagement.dto.StockDto;
import com.example.orderManagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<StockDto> createStock(@RequestBody StockDto stockDto) {
        StockDto createdStock = stockService.createStock(stockDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
    }

    @GetMapping
    public ResponseEntity<List<StockDto>> getAllStocks() {
        List<StockDto> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> getStockById(@PathVariable int id) {
        StockDto stock = stockService.getStockById(id);
        return ResponseEntity.ok(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockById(@PathVariable int id) {
        stockService.deleteStockById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDto> updateStock(@RequestBody StockDto stockDto, @PathVariable int id) {
        StockDto updatedStock = stockService.updateStock(stockDto, id);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }
}
