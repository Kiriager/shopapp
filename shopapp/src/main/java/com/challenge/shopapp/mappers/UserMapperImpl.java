package com.challenge.shopapp.mappers;

import java.util.HashSet;
import java.util.Set;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.domain.User;
import com.challenge.shopapp.dto.UserDto;

public class UserMapperImpl implements UserMapper {

  @Override
  public UserDto toDto(User src) {
    if (src == null) {
      return null;
    }

    UserDto dto = new UserDto();

    dto.setId(src.getId());
    dto.setFirstName(src.getFirstName());
    dto.setLastName(src.getLastName());
    dto.setAmountOfMoney(src.getAmountOfMoney());

    for (Product product : src.getBoughtProducts()) {
      dto.getBoughtProductsIds().add(product.getId());
    }
  
    return dto;
  }

  @Override
  public Set<UserDto> toDto(Iterable<User> src) {
    Set<UserDto> dto = new HashSet<UserDto>();
    for (User user : src) {
      dto.add(this.toDto(user));
    }
    return dto;
  }
  
}
