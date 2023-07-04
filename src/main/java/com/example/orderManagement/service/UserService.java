package com.example.orderManagement.service;

import com.example.orderManagement.dto.StockDto;
import com.example.orderManagement.dto.UserDto;

import java.util.List;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    void deleteUserById(Long id);
    UserDto updateUser(UserDto userDto, Long id);
}


