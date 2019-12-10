package com.yang.hateoas.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

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
