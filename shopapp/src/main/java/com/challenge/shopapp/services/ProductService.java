package com.challenge.shopapp.services;

import java.util.Set;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.domain.User;

public interface ProductService {
  Set<Product> findAll();

  Product create(String title, Double price);
  //Post update(Long id, User author, String title, String body);
  
  Product addUserWhoBought(Long productId, User user);

  void delete(Long id);
  
  Product find(Long id);
  
}
