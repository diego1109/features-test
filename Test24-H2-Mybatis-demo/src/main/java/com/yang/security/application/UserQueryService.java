package com.yang.security.application;

import com.yang.security.application.data.UserData;
import com.yang.security.infrastructure.mybatis.query.UserReadService;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class UserQueryService {

  private UserReadService userReadService;

  public UserQueryService(UserReadService userReadService) {
    this.userReadService = userReadService;
  }

  public Optional<UserData> findById(String id) {
    return Optional.ofNullable(userReadService.findById(id));
  }

}
