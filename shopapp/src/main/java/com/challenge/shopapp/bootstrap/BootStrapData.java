package com.challenge.shopapp.bootstrap;

import org.springframework.boot.CommandLineRunner;

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
    
  }
  
}
