package com.yang.jackson.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonRootName("employee")
public class Employee {
  
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("frist_name")
  private String fristName;
  @JsonProperty("last_name")
  private String lastName;
  
  public Employee(Integer id, String fristName, String lastName) {
    this.id = id;
    this.fristName = fristName;
    this.lastName = lastName;
  }
  
  @JsonCreator
  public Employee(@JsonProperty("frist_name") String fristName,
      @JsonProperty("last_name") String lastName,@JsonProperty("id") Integer id) {
    this.fristName = fristName;
    this.lastName = lastName;
    this.id = id;
  }
}

