package com.challenge.shopapp.services;

import java.util.Set;

import com.challenge.shopapp.domain.User;

public interface UserService {
  Set<User> findAll();

  User create(String firstName, String lastName, Double amountOfMoney);
  //Post update(Long id, User author, String title, String body);
  
  void delete(Long id);
  
  User find(Long id);
}
