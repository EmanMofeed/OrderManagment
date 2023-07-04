package com.example.orderManagement.service.impl;

import com.example.orderManagement.dto.UserDto;
import com.example.orderManagement.entity.UserEntity;
import com.example.orderManagement.exception.ResourceNotFoundException;
import com.example.orderManagement.repository.UserRepository;
import com.example.orderManagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity user = mapToEntity(userDto);
        UserEntity newUser = userRepository.save(user);
        return mapToDto(newUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapToDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        // Update the properties of the user entity using userDto
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());

        UserEntity updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    private UserEntity mapToEntity(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        return user;
    }

    private UserDto mapToDto(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
