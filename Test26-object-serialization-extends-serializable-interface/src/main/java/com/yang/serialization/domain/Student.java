package com.yang.serialization.domain;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Data
@ToString
public class Student {
  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String company;

  public Student(String id, String name, String company) {
    this.id = id;
    this.name = name;
    this.company = company;
  }
}
