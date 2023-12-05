package com.example.natv.services.impl;

import com.example.natv.mappers.UserMapper;
import com.example.natv.models.dto.UserDto;
import com.example.natv.models.entities.User;
import com.example.natv.repository.UserRepo;
import com.example.natv.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    public UserServiceImpl( UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDto save(UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepo.save(user);
        userDto.setId(user.getId());
        return userDto;
    }
    @Override
    public List <User> findAll() {
        return userRepo.findAll();
    }
}
