package com.yang.mybatis.application;

import com.yang.mybatis.application.data.ArticleData;
import java.util.List;
import java.util.Optional;

public interface ArticleQueryService {

  public Optional<ArticleData> findbyId(String articleId);

  public List<ArticleData> findByUserId(String userId);

  public List<String> findArticleIdsOfUser(String userId);
}
