package io.cheonkyu;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private String name = "cheonkyu-test";
  private Car car;

  public Person(@Qualifier("car") Car car) {
    this.car = car;
  }

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
