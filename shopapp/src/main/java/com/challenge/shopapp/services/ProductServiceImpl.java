package com.challenge.shopapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.exceptions.ProductNotFoundException;
import com.challenge.shopapp.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
    
  @Override
  public Set<Product> findAll() {
    Iterable<Product> products = productRepository.findAll();
    Set<Product> result = new HashSet<Product>();

    for (Product product : products) {
      result.add(product); 
    }

    return result;
  }

  @Override
  public Product find(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id));
  }
  
}
