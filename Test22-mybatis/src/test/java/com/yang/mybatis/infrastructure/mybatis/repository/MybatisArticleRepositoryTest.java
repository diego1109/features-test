package com.yang.mybatis.infrastructure.mybatis.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.yang.mybatis.domain.Article;
import com.yang.mybatis.domain.ArticleRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@Import(MybatisArticleRepository.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MybatisArticleRepositoryTest {

  @Autowired
  private ArticleRepository articleRepository;

  private String userId;

  @Before
  public void setUp(){
    userId = UUID.randomUUID().toString();
  }

  /**
   * 单个object保存于读取
   */
  @Test
  public void should_save_article_succeed(){
    Article article = new Article(userId,"article content");
    articleRepository.save(article);

    Optional<Article> optional = articleRepository.findById(article.getId());
    assertThat(optional.isPresent(), is(true));

    Article refetch = optional.get();
    assertThat(refetch.getId(),is(article.getId()));
    assertThat(refetch.getUserId(),is(userId));
    assertThat(refetch.getBody(),is(article.getBody()));
  }

}