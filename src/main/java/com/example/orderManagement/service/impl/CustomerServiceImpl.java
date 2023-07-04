package com.example.orderManagement.service.impl;

import com.example.orderManagement.dto.CustomerDto;
import com.example.orderManagement.entity.Customer;
import com.example.orderManagement.exception.ResourceNotFoundException;
import com.example.orderManagement.repository.CustomerRepository;
import com.example.orderManagement.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);
        return mapToDTO(newCustomer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return mapToDTO(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

        // Update the properties of the customer entity using customerDto

        Customer updatedCustomer = customerRepository.save(customer);
        return mapToDTO(updatedCustomer);
    }

    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setBornAt(customerDto.getBornAt());
        return customer;
    }

    private CustomerDto mapToDTO(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setBornAt(customer.getBornAt());
        return customerDto;
    }
}
