package com.yang.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.concurrent.TransferQueue;
import lombok.Getter;

@Getter
@JsonRootName("employee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
  
  private String fristName;
  private String lastName;
  
  @JsonCreator
  public Name(@JsonProperty("frist_name") String fristName,
      @JsonProperty("last_name") String lastName) {
    this.fristName = fristName;
    this.lastName = lastName;
  }
}
