package com.yang.hateoas.api;

import lombok.Getter;

@Getter
public class Link {

  private String rel;
  private String href;

  public Link(String rel, String href) {
    this.rel = rel;
    this.href = href;
  }
}
