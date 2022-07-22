package com.challenge.shopapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;
  private String lastName;
  private Double amountOfMoney;

  @ManyToMany(mappedBy = "usersWhoBought")
  Set<Product> boughtProducts = new HashSet<Product>();

  public User(String firstName, String lastrName, Double amountOfMoney) {
    this.firstName = firstName;
    this.lastName = lastrName;
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

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastrName) {
    this.lastName = lastrName;
  }

  public Double getAmountOfMoney() {
    return this.amountOfMoney;
  }

  public void setAmountOfMoney(Double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public Set<Product> getBoughtProducts() {
    return boughtProducts;
  }

  public void setBoughtProducts(Set<Product> boughtProducts) {
    this.boughtProducts = boughtProducts;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }


  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", firstName='" + getFirstName() + "'" +
        ", lastName='" + getLastName() + "'" +
        ", amountOfMoney='" + getAmountOfMoney() + "'" +
        "}";
  }


}
