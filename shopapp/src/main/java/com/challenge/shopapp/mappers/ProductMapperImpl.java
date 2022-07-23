package com.challenge.shopapp.mappers;

import java.util.HashSet;
import java.util.Set;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.domain.User;
import com.challenge.shopapp.dto.ProductDto;

public class ProductMapperImpl implements ProductMapper {

  @Override
  public ProductDto toDto(Product src) {
    if (src == null) {
      return null;
    }

    ProductDto dto = new ProductDto();

    dto.setId(src.getId());
    dto.setTitle(src.getTitle());
    dto.setPrice(src.getPrice());

    for (User user : src.getUsersWhoBought()) {
      dto.getUsersWhoBoughtIds().add(user.getId());
    }
  
    return dto;
  }

  @Override
  public Set<ProductDto> toDto(Iterable<Product> src) {
    Set<ProductDto> dto = new HashSet<ProductDto>();
    for (Product product : src) {
      dto.add(this.toDto(product));
    }
    return dto;
  }
  
}
