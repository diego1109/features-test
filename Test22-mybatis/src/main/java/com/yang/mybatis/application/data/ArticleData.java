package com.yang.mybatis.application.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
public class ArticleData {

  private String id;
  private String userId;
  private String body;
}
