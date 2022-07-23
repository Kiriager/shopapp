package com.challenge.shopapp.exceptions;

public class NotEnoughMoney extends RuntimeException {
  public NotEnoughMoney(Long userId, Long productId) {
    super("User Id = " + userId + 
        "doesn't have enough money to by product Id = " + productId);
  }
}
