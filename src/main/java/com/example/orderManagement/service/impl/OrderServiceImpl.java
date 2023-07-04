package com.example.orderManagement.service.impl;

import com.example.orderManagement.dto.OrderDto;
import com.example.orderManagement.entity.Customer;
import com.example.orderManagement.entity.OrderEntity;
import com.example.orderManagement.exception.ResourceNotFoundException;
import com.example.orderManagement.repository.OrderRepository;
import com.example.orderManagement.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity order = mapToEntity(orderDto);
        OrderEntity newOrder = orderRepository.save(order);
        return mapToDTO(newOrder);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(int id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        return mapToDTO(order);
    }

    @Override
    public void deleteOrderById(int id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        orderRepository.delete(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, int id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

        // Update the properties of the order entity using orderDto

        OrderEntity updatedOrder = orderRepository.save(order);
        return mapToDTO(updatedOrder);
    }

    private OrderEntity mapToEntity(OrderDto orderDto) {
        OrderEntity order = new OrderEntity();
        order.setId(orderDto.getId());
        order.setOrderedAt(orderDto.getOrderedAt());
        Customer customer = new Customer();
        customer.setId(orderDto.getCustomerId());
        order.setCustomer(customer);

        return order;
    }

    private OrderDto mapToDTO(OrderEntity order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrderedAt(order.getOrderedAt());
        int customerId = order.getCustomer().getId();
        orderDto.setCustomerId(customerId);
        return orderDto;
    }
}

