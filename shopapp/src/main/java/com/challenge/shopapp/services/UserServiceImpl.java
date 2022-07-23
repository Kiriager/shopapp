package com.challenge.shopapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.shopapp.domain.User;
import com.challenge.shopapp.exceptions.UserNotFoundException;
import com.challenge.shopapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
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
    // TODO Auto-generated method stub
    return null;
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
  
}
