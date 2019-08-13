package com.yang.mybatis.infrastructure.mybatis.query;

import com.yang.mybatis.application.ArticleQueryService;
import com.yang.mybatis.application.data.ArticleData;
import com.yang.mybatis.infrastructure.mybatis.mapper.ArticleQueryMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisArticleQueryService implements ArticleQueryService {

  private ArticleQueryMapper articleQueryMapper;

  @Autowired
  public MybatisArticleQueryService(ArticleQueryMapper articleQueryMapper) {
    this.articleQueryMapper = articleQueryMapper;
  }

  @Override
  public Optional<ArticleData> findbyId(String articleId) {
    return Optional.ofNullable(articleQueryMapper.findById(articleId));
  }

  @Override
  public List<ArticleData> findByUserId(String userId) {
    return articleQueryMapper.findByUserId(userId);
  }

  @Override
  public List<String> findArticleIdsOfUser(String userId) {
    return articleQueryMapper.findArticles(userId);
  }
}
