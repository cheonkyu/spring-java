package io.cheonkyu.controller;

public class Payment {
  private String id;
  private int amount;

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}
