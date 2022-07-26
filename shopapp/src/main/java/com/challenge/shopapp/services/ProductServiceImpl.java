package com.challenge.shopapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.domain.User;
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

  @Override
  public Product create(String title, Double price) {
    Product entity = new Product();
    entity.setTitle(title);
    entity.setPrice(price);
    return productRepository.save(entity);
  }

  @Override
  public void delete(Long id) {
    Product entity = find(id);
    productRepository.delete(entity);    
  }

  @Override
  public Product addUserWhoBought(Long productId, User user) {
    Product product = find(productId);
    product.getUsersWhoBought().add(user);
    return productRepository.save(product);   
  }

  @Override
  public Set<Product> findBoughtByUser(Long id) {
    Set<Product> result = new HashSet<Product>();

    for (Product product : findAll()) {
      if (isBoughtByUser(product, id)){
        result.add(product);
      }
    }

    return result;
  }

  private boolean isBoughtByUser(Product product, Long userId) {
    for (User user : product.getUsersWhoBought()) {
      if (user.getId() == userId) {
        return true;
      }
    }
    return false;
  }
}
