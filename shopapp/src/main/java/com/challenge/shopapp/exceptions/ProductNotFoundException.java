package com.challenge.shopapp.exceptions;


public class ProductNotFoundException extends RuntimeException{
  String message;

  public ProductNotFoundException(Long id) {
    super("Product Id = " + id + " doesn't exist");
    message = "Product Id = " + id + " doesn't exist";
  }

  @Override
  public String getMessage() {
    return message;
  }
}
