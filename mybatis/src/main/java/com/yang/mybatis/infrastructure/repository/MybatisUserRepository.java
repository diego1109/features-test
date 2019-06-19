package com.yang.mybatis.infrastructure.repository;

import com.yang.mybatis.core.user.User;
import com.yang.mybatis.core.user.UserRepository;
import com.yang.mybatis.infrastructure.mybatis.UserMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisUserRepository implements UserRepository {

  private UserMapper userMapper;

  @Autowired
  public MybatisUserRepository(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public void save(User user) {
    if(userMapper.findById(user.getId()) == null){
      userMapper.insert(user);
    }else {
      userMapper.update(user);
    }
  }

  @Override
  public Optional<User> findById(String id) {
    return Optional.ofNullable(userMapper.findById(id));
  }

  @Override
  public Optional<User> findByUserName(String userName) {
    return Optional.empty();
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return Optional.empty();
  }
}
