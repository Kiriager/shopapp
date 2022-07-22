package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Double price;
  
  public Product(String title, Double price) {
    this.price = price;
    this.title = title;
  }

  public Product() {
  }

  //@ManyToOne
  //private Location location;

}
