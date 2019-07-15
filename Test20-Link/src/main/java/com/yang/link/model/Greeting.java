package com.yang.link.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Greeting extends ResourceSupport {

  private final String content;


  public Greeting(String content) {
    this.content = content;
  }

  public String getContent(){
    return content;
  }
}
