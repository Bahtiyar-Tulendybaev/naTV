package com.example.natv.services;

import com.example.natv.models.dto.UserDto;
import com.example.natv.models.entities.User;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    List<User> findAll();
}
