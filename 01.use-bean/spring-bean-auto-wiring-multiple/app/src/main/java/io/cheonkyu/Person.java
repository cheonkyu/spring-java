package io.cheonkyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private String name = "cheonkyu-test";
  private Car car;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  // setter 방식은 지원하지만 쓰면 안됌7777777777777777777777777777
  @Autowired
  public void setCar(Car car) {
    this.car = car;
  }

  public Car getCar() {
    return this.car;
  }
}
