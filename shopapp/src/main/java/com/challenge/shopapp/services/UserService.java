package com.challenge.shopapp.services;

import java.util.Set;

import com.challenge.shopapp.domain.User;

public interface UserService {
  Set<User> findAll();

  User create(String firstName, String lastName, Double amountOfMoney);
  
  //User update(User user);
  
  void delete(Long id);
  
  User find(Long id);

  User buyProduct(Long userId, Long productId);
}
