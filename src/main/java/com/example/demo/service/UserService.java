package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
    List<UserDto> getAllUsers();

}
