package com.challenge.shopapp.exceptions;

public class UserNotFoundException extends RuntimeException {
  
  String message;

  public UserNotFoundException(Long id) {
    super("User with Id = " + id + "doesn't exist");
    message = "User Id = " + id + " doesn't exist";
  }

  @Override
  public String getMessage() {
    return message;
  }
}


