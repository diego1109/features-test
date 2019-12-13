package com.yang.hateoas.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.util.Assert;

@JsonInclude(Include.NON_NULL)
public class Resource<T> {

  private T content;
  private Map<String, String> links = new LinkedHashMap<>();

  public Resource(T content, Iterable<Link> links) {
    Assert.notNull(content, "Content must not be null");
    this.content = content;
    this.add(links);
  }

  public Resource(T content, Link... links) {
    Assert.notNull(content, "Content must not be null");
    this.content = content;
    this.add(links);
  }

  public void add(Iterable<Link> links) {
    Assert.notNull(links, "Givens links must not be null");
    for (Link link : links) {
      add(link);
    }
  }

  public void add(Link... links) {
    Assert.notNull(links, "links must not be null");
    add(Arrays.asList(links));
  }

  public void add(Link link) {
    Assert.notNull(content, "Link must not be null!");
    this.links.put(link.getRel(), link.getHref());
  }

  @JsonUnwrapped
  public T getContent() {return this.content;}

  public Map<String, String> getLinks() {return Collections.unmodifiableMap(links);}
}
