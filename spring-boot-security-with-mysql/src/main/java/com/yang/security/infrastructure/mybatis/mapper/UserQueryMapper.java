package com.yang.security.infrastructure.mybatis.mapper;

import com.yang.security.application.data.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserQueryMapper {

  UserData findById(String id);

  UserData findByUsername(String userName);
}
