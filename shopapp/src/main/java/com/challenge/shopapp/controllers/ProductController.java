package com.challenge.shopapp.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.dto.ProductDto;
import com.challenge.shopapp.mappers.ProductMapper;
import com.challenge.shopapp.mappers.ProductMapperImpl;
import com.challenge.shopapp.services.ProductService;


@RestController
public class ProductController {
  
  private final ProductService productService;
  private final ProductMapper productMapper = new ProductMapperImpl();

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(value = "/products")
  public Set<ProductDto> getProducts() {
    return productMapper.toDto(productService.findAll());
  }

  @GetMapping(value = "/products/{id}")
  public ProductDto getProduct(@PathVariable("id") Long id) {
    Product product = productService.find(id);
    return productMapper.toDto(product);
  }
  
}
