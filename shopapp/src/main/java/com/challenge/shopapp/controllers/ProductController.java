package com.challenge.shopapp.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.dto.ProductDto;
import com.challenge.shopapp.mappers.ProductMapper;
import com.challenge.shopapp.mappers.ProductMapperImpl;
import com.challenge.shopapp.repositories.ProductRepository;

@RestController
public class ProductController {
  
  private final ProductRepository productRepository;
  private static final ProductMapper productMapper = new ProductMapperImpl();

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping(value = "/products")
  public Set<ProductDto> getproducts() {
    Iterable<Product> products = productRepository.findAll();
    Set<ProductDto> dtos = new HashSet<ProductDto>();
    
    for (Product product : products) {
      dtos.add(productMapper.toDto(product));
    }
    
    return dtos;
  }
  
}
