package com.yang.hateoas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;

public class Greeting extends ResourceSupport {
  
  @JsonProperty("content")
  private final String content;
  
  @JsonCreator
  public Greeting(String content) {
    this.content = content;
  }
  
  public String getContent() {
    return content;
  }
}
