package com.challenge.shopapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.challenge.shopapp.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
  
}
