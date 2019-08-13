package com.yang.mybatis.domain;


import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Article {
  private String id;
  private String userId;
  private String body;

  public Article(String userId, String body) {
    this.id = UUID.randomUUID().toString();
    this.userId = userId;
    this.body = body;
  }
}
