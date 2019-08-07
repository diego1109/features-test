package com;

public class Father {

  protected String name;
  private String father = "ssss";

  public Father(String name) {
    this.name = name;
  }

  public void print(){
    System.out.println(this.name);
  }

  public String getName() {
    System.out.println("--- get father ---");
    return father;
  }
}
