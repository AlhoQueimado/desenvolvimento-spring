package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

public class UserMapper {
    public static UserDto maptoDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(), user.getName(), user.getEmail(), user.getPassword()
        );

        return userDto;
    }

    public static User maptoEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());


        return user;
    }
}
