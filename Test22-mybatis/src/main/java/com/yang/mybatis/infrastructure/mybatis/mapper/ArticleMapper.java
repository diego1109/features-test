package com.yang.mybatis.infrastructure.mybatis.mapper;

import com.yang.mybatis.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ArticleMapper {

  void save(@Param("article") Article article);

  Article findById(@Param("articleId") String articleId);
}
