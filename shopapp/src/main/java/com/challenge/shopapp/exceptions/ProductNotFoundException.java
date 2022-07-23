package com.challenge.shopapp.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(Long id) {
    super("Could not find product with Id = " + id);
  }
}
