package com.example.orderManagement.service;

import com.example.orderManagement.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(int id);
    void deleteCustomerById(int id);
    CustomerDto updateCustomer(CustomerDto customerDto, int id);
}
