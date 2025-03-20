package io.cheonkyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private String name = "cheonkyu-test";

  @Autowired
  private Car car;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Car getCar() {
    return this.car;
  }
}
