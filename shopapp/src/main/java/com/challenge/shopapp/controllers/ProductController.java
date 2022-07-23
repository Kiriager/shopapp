package com.challenge.shopapp.controllers;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.dto.CreateProductDto;
import com.challenge.shopapp.dto.ProductDto;
import com.challenge.shopapp.mappers.ProductMapper;
import com.challenge.shopapp.mappers.ProductMapperImpl;
import com.challenge.shopapp.services.ProductService;




@RestController
@Validated
public class ProductController {
  
  private final ProductService productService;
  private final ProductMapper productMapper = new ProductMapperImpl();

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(value = "/products")
  public Set<ProductDto> getAllProducts() {
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

  @DeleteMapping(value = "/products/{id}")
  public void removeProduct(@PathVariable("id") Long id){
    productService.delete(id);
  }
  
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }

}
