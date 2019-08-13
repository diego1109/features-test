package com.yang.mybatis.infrastructure.mybatis.query;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.yang.mybatis.application.ArticleQueryService;
import com.yang.mybatis.application.data.ArticleData;
import com.yang.mybatis.domain.Article;
import com.yang.mybatis.domain.ArticleRepository;
import com.yang.mybatis.infrastructure.mybatis.repository.MybatisArticleRepository;
import java.util.List;
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
@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import({MybatisArticleRepository.class, MybatisArticleQueryService.class})
public class MybatisArticleQueryServiceTest {

  @Autowired
  private ArticleRepository articleRepository;

  @Autowired
  private ArticleQueryService queryService;

  private String userId;

  @Before
  public void setUp(){
    userId = UUID.randomUUID().toString();
  }


  /**
   * 查询单个object
   */
  @Test
  public void should_get_article_by_id(){
    Article article = new Article(userId,"article body");
    articleRepository.save(article);

    Optional<ArticleData> optional = queryService.findbyId(article.getId());
    assertThat(optional.isPresent(),is(true));
    ArticleData articleData = optional.get();
    assertThat(articleData.getId(),is(article.getId()));
    assertThat(articleData.getUserId(),is(article.getUserId()));
    assertThat(articleData.getBody(),is(article.getBody()));
  }

  /**
   * 查询多个object
   */
  @Test
  public void should_get_articles_by_user_id(){
    Article article1 = new Article(userId,"article body1");
    articleRepository.save(article1);
    Article article2 = new Article(userId,"article body2");
    articleRepository.save(article2);

    List<ArticleData> articleDatas = queryService.findByUserId(userId);
    assertThat(articleDatas.size(),is(2));
    assertThat(articleDatas.get(0).getUserId(),is(userId));
    assertThat(articleDatas.get(1).getUserId(),is(userId));
    System.out.println(articleDatas.get(0));
    System.out.println(articleDatas.get(1));
  }

  /**
   * 查询多个String
   */

  @Test
  public void should_get_articles_id_by_user_id(){
    Article article1 = new Article(userId,"article body1");
    articleRepository.save(article1);
    Article article2 = new Article(userId,"article body2");
    articleRepository.save(article2);

    List<String> articleIds = queryService.findArticleIdsOfUser(userId);
    assertThat(articleIds.size(),is(2));
    System.out.println(articleIds.get(0));
    System.out.println(articleIds.get(1));
  }


}