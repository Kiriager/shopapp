package com.challenge.shopapp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateProductDto {
  @NotBlank(message = "Product title is mandatory")
  @Size(min = 2, max = 50, message = "Product title must be 2-50 characters long")
  private String title;

  @NotNull(message = "Product price is mandatory")
  @DecimalMin(value = "0.01", message = "Product price should be more than 0.01")
  private Double price;

  public CreateProductDto() {
  }

  public CreateProductDto(String title, Double price) {
    this.title = title;
    this.price = price;
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

}
