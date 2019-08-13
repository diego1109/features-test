package com.yang.mybatis.domain;

import java.util.Optional;


public interface ArticleRepository {

  public void save(Article article);

  public Optional<Article> findById(String articleId);
}
