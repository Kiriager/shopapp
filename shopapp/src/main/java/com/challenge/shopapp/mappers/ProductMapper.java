package com.challenge.shopapp.mappers;

import java.util.Set;

import org.mapstruct.Mapper;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.dto.ProductDto;

@Mapper
public interface ProductMapper {
  ProductDto toDto(Product src);
  Set<ProductDto> toDto(Iterable<Product> src);
}
