package com.challenge.shopapp.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastrName;
  private Double amountOfMoney;

  public User(String firstName, String lastrName, Double amountOfMoney) {
    this.firstName = firstName;
    this.lastrName = lastrName;
    this.amountOfMoney = amountOfMoney;
  }

  public User() {
  }

  public Long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastrName() {
    return this.lastrName;
  }

  public void setLastrName(String lastrName) {
    this.lastrName = lastrName;
  }

  public Double getAmountOfMoney() {
    return this.amountOfMoney;
  }

  public void setAmountOfMoney(Double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

}
