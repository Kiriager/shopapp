package com.challenge.shopapp.dto;

import java.util.HashSet;
import java.util.Set;

public class ProductDto {
  
  private Long id;
  private String title;
  private Double price;
  Set<Long> usersWhoBoughtIds = new HashSet<Long>();

  public ProductDto() {
  }

  public ProductDto(Long id, String title, Double price, Set<Long> usersWhoBoughtIds) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.usersWhoBoughtIds = usersWhoBoughtIds;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Set<Long> getUsersWhoBoughtIds() {
    return this.usersWhoBoughtIds;
  }

  public void setUsersWhoBoughtIds(Set<Long> usersWhoBoughtIds) {
    this.usersWhoBoughtIds = usersWhoBoughtIds;
  }

}
