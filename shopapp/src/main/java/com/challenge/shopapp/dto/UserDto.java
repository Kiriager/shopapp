package com.challenge.shopapp.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
  private Long id;
  private String firstName;
  private String lastName;
  private Double amountOfMoney;
  Set<Long> boughtProductsIds = new HashSet<Long>();


  public UserDto() {
  }

  public UserDto(Long id, String firstName, String lastName, Double amountOfMoney) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.amountOfMoney = amountOfMoney;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Double getAmountOfMoney() {
    return this.amountOfMoney;
  }

  public void setAmountOfMoney(Double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }


  public Set<Long> getBoughtProductsIds() {
    return this.boughtProductsIds;
  }

  public void setBoughtProductsIds(Set<Long> boughtProductsIds) {
    this.boughtProductsIds = boughtProductsIds;
  }

}
