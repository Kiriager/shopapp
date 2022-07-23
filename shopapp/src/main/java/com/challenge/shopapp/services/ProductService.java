package com.challenge.shopapp.services;

import java.util.Set;

import com.challenge.shopapp.domain.Product;

public interface ProductService {
  Set<Product> findAll();

  Product create(String title, Double price);
  //Post update(Long id, User author, String title, String body);
  
  //void delete(Long id, User author);
  
  Product find(Long id);
  
}
