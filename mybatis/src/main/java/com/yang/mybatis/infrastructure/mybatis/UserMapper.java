package com.yang.mybatis.infrastructure.mybatis;


import com.yang.mybatis.core.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  User findById(@Param("id") String id);

  void insert(@Param("user") User user);

  void update(@Param("user") User user);
}
