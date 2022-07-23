package com.challenge.shopapp.services;

import java.util.Set;

import com.challenge.shopapp.domain.Product;

public interface ProductService {
  Set<Product> findAll();
}
