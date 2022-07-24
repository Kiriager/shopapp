package com.challenge.shopapp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserDto {
  @NotBlank(message = "First name is mandatory")
  @Size(min = 2, max = 50, message = "First name must be 2-50 characters long")
  private String firstName;

  @NotBlank(message = "Last name is mandatory")
  @Size(min = 2, max = 50, message = "Last namr must be 2-50 characters long")
  private String lastName;

  @NotNull(message = "User mount of money is mandatory")
  @DecimalMin(value = "0.0", message = "Amount of money should be positive number")
  private Double amountOfMoney;


  public CreateUserDto() {
  }

  public CreateUserDto(String firstName, String lastName, Double amountOfMoney) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.amountOfMoney = amountOfMoney;
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


  @Override
  public String toString() {
    return "{" +
      " firstName='" + getFirstName() + "'" +
      ", lastName='" + getLastName() + "'" +
      ", amountOfMoney='" + getAmountOfMoney() + "'" +
      "}";
  }

}
