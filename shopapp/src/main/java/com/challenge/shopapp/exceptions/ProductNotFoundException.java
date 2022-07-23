package com.challenge.shopapp.exceptions;

public class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(Long id) {
    super("Could not find product with Id = " + id);
  }
}
