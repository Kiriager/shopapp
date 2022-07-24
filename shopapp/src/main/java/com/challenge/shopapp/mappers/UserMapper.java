package com.challenge.shopapp.mappers;

import java.util.Set;

import org.mapstruct.Mapper;

import com.challenge.shopapp.domain.User;
import com.challenge.shopapp.dto.CreateUserDto;
import com.challenge.shopapp.dto.UserDto;

@Mapper
public interface UserMapper {
  UserDto toDto(User src);
  
  Set<UserDto> toDto(Iterable<User> src);

  User toSrc(CreateUserDto dto);
}