package domain;

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
}
