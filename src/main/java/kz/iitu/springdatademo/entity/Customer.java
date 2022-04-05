package kz.iitu.springdatademo.entity;

import javax.persistence.*;

@Entity
public class Customer {

  @Id
  private int id;

  private String name;
  private String pin;

  public Customer() {}

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPin() {
    return pin;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }
}