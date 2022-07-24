package com.challenge.shopapp.exceptions;

public class NotEnoughMoneyException extends RuntimeException {
  public NotEnoughMoneyException(Long userId, Long productId) {
    super("User Id = " + userId + 
        " oesn't have enough money to by product Id = " + productId);
  }
}
