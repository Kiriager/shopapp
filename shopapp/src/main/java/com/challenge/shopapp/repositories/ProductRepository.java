package com.challenge.shopapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.challenge.shopapp.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
