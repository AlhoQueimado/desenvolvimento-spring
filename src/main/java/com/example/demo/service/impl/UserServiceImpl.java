package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Achievement;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.AchievementMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.AchievementRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final AchievementRepository achievementRepository;
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.maptoEntity(userDto);
        User savedUser = userRepository.save(user);


        return UserMapper.maptoDto(savedUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        user = UserMapper.maptoEntity(userDto);
        user.setId(id);
        User savedUser = userRepository.save(user);

        return UserMapper.maptoDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return UserMapper.maptoDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(UserMapper.maptoDto(user));
        }
        return userDtos;
    }
}
