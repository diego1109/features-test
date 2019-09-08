package com.yang.security.infrastructure.mybatis.query;

import com.yang.security.application.UserQueryService;
import com.yang.security.application.data.UserData;
import com.yang.security.infrastructure.mybatis.mapper.UserQueryMapper;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class MybatisUserQueryService implements UserQueryService {

  private UserQueryMapper userQueryMapper;

  public MybatisUserQueryService(UserQueryMapper userQueryMapper) {
    this.userQueryMapper = userQueryMapper;
  }

  public Optional<UserData> findById(String id) {
    return Optional.ofNullable(userQueryMapper.findById(id));
  }

  public Optional<UserData> findByUsername(String userName) {
    return Optional.ofNullable(userQueryMapper.findByUsername(userName));
  }
}
