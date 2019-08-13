package com.yang.mybatis.infrastructure.mybatis.mapper;

import com.yang.mybatis.application.data.ArticleData;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ArticleQueryMapper {

  ArticleData findById(@Param("articleId") String articleId);

  List<ArticleData> findByUserId(@Param("userId") String userId);

  List<String> findArticles(@Param("userId") String userId);
}
