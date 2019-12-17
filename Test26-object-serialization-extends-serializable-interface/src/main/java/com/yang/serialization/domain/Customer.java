package com.yang.serialization.domain;


import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Data
@ToString
public class Customer implements Serializable {

  private static final long serialVersionUID = 2L;

  private String id;
  private String name;
  private String company;



  public Customer(String id, String name, String company) {
    this.id = id;
    this.name = name;
    this.company = company;
  }
}
