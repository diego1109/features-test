package com.yang.security.infrastructure.mybatis.mapper;

import com.yang.security.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserMapper {
  void insert(@Param("user") User user);

  User findById(@Param("id") String id);

  User findByUsername(@Param("username") String username);

  void update(@Param("user") User user);
}
