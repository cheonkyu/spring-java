package io.cheonkyu;

public class Car {
  private String name;

  public Car() {
    System.out.println("Car created");
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
