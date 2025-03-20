package io.cheonkyu.services;

public class Comment {
  private String text;
  private String author;

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return this.author;
  }
}
