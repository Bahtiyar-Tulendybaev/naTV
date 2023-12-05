package com.example.natv.mappers;

import com.example.natv.models.dto.UserDto;
import com.example.natv.models.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userDtoToUser(User user);

    @InheritInverseConfiguration
    User userDtoToUser(UserDto userDto);
}
