package com.challenge.shopapp.controllers;

import javax.validation.Valid;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.dto.CreateProductDto;
import com.challenge.shopapp.dto.ProductDto;
import com.challenge.shopapp.mappers.ProductMapper;
import com.challenge.shopapp.mappers.ProductMapperImpl;
import com.challenge.shopapp.services.ProductService;


@RestController
public class ProductController {
  
  private final ProductService productService;
  private final ProductMapper productMapper = new ProductMapperImpl();

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

  @PostMapping("/products")
  public ProductDto addProduct(@Valid @RequestBody CreateProductDto dto) {
    Product newProduct = productService.create(dto.getTitle(), dto.getPrice());
    return productMapper.toDto(newProduct);
  }
  
}
