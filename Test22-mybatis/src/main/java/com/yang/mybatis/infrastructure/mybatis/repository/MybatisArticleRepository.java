package com.yang.mybatis.infrastructure.mybatis.repository;

import com.yang.mybatis.domain.Article;
import com.yang.mybatis.domain.ArticleRepository;
import com.yang.mybatis.infrastructure.mybatis.mapper.ArticleMapper;
import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisArticleRepository implements ArticleRepository {

  private ArticleMapper articleMapper;

  public MybatisArticleRepository(ArticleMapper articleMapper) {
    this.articleMapper = articleMapper;
  }

  @Override
  public void save(Article article) {
    if(articleMapper.findById(article.getId())  == null){
      articleMapper.save(article);
    }
  }

  @Override
  public Optional<Article> findById(String articleId){
    return Optional.ofNullable(articleMapper.findById(articleId));
  }
}
