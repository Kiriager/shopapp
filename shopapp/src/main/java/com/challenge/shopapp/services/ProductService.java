package com.challenge.shopapp.services;

import java.util.Set;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.domain.User;

public interface ProductService {
  Set<Product> findAll();

  Set<Product> findBoughtByUser(Long id);

  Product create(String title, Double price);
  
  Product addUserWhoBought(Long productId, User user);

  void delete(Long id);
  
  Product find(Long id);
  
}
