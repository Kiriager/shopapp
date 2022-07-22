package com.challenge.shopapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Double price;

  @ManyToMany
  @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  Set<User> usersWhoBought = new HashSet<User>();
  
  public Product(String title, Double price) {
    this.price = price;
    this.title = title;
  }

  public Product() {
  }

  public Long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Set<User> getUsersWhoBought() {
    return usersWhoBought;
  }
  
  public void setUsersWhoBought(Set<User> usersWhoBought) {
    this.usersWhoBought = usersWhoBought;
  }

}
