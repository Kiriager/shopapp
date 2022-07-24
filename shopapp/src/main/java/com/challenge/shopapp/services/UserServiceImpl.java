package com.challenge.shopapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.shopapp.domain.Product;
import com.challenge.shopapp.domain.User;
import com.challenge.shopapp.exceptions.NotEnoughMoneyException;
import com.challenge.shopapp.exceptions.UserNotFoundException;
import com.challenge.shopapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ProductService productService;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, ProductService productService) {
    this.userRepository = userRepository;
    this.productService = productService;
  }

  @Override
  public Set<User> findAll() {
    Iterable<User> users = userRepository.findAll();
    Set<User> result = new HashSet<User>();

    for (User user : users) {
      result.add(user); 
    }

    return result;
  }

  @Override
  public User create(String firstName, String lastName, Double amountOfMoney) {
    User entity = new User();
    entity.setFirstName(firstName);
    entity.setLastName(lastName);
    entity.setAmountOfMoney(amountOfMoney);
    return userRepository.save(entity);
  }

  @Override
  public void delete(Long id) {
    User entity = find(id);
    userRepository.delete(entity);
  }

  @Override
  public User find(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @Override
  public User buyProduct(Long userId, Long productId) {
    if (find(userId).getAmountOfMoney() < productService.find(productId).getPrice()) {
      throw new NotEnoughMoneyException(userId, productId);
    } else {
      Product product = productService.addUserWhoBought(productId, find(userId));
      User user = find(userId);
      user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
      user.getBoughtProducts().add(product);
      return userRepository.save(user);
    }
  }
  
}
