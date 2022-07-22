package com.challenge.shopapp.bootstrap;

import org.springframework.boot.CommandLineRunner;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.domain.User;
import com.challenge.shopapp.repositories.ProductRepository;
import com.challenge.shopapp.repositories.UserRepository;

public class BootStrapData implements CommandLineRunner {
  private final UserRepository userRepository;
  private final ProductRepository productRepository;
  

  public BootStrapData(UserRepository userRepository, ProductRepository productRepository) {
    this.userRepository = userRepository;
    this.productRepository = productRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User("Honey", "Badger", 500.0);
    User user2 = new User("Hedwig", "Owl", 1500.0);
    
    Product product1 = new Product("Book", 200.0);
    Product product2 = new Product("Knife", 400.0);

    userRepository.save(user1);
    userRepository.save(user2);

    productRepository.save(product1);
    productRepository.save(product2);

    System.out.println(userRepository.count());
    System.out.println(productRepository.count());
  }
  
}
