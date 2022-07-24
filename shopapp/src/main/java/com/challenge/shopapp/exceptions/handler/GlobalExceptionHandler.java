package com.challenge.shopapp.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.challenge.shopapp.exceptions.NotEnoughMoneyException;
import com.challenge.shopapp.exceptions.ProductNotFoundException;
import com.challenge.shopapp.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {ProductNotFoundException.class, UserNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ErrorResponse handleNotFoundEntityException(RuntimeException ex) {
    return new ErrorResponse(
        HttpStatus.NOT_FOUND.value(), ex.getMessage());
  }

  @ExceptionHandler(value = NotEnoughMoneyException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public @ResponseBody ErrorResponse handleNotEnoughMoneyException(
      NotEnoughMoneyException ex) {
    return new ErrorResponse(
        HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
  }
 
}