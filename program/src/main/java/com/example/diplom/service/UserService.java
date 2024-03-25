package com.example.diplom.service;

import com.example.diplom.dto.UserDto;
import com.example.diplom.model.User;

import java.util.List;

public interface UserService {
    void saveUserDto(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

    void saveUser(User user);
}



