package com.yang.mybatis.infrastructure.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import com.yang.mybatis.core.user.User;
import com.yang.mybatis.core.user.UserRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MybatisTest
@Import(MybatisUserRepository.class)
@AutoConfigureTestDatabase(replace = NONE)
public class MybatisUserRepositoryTest {
  @Autowired
  private UserRepository userRepository;
  private User user;

  @Before
  public void setUp() throws Exception {
    user = new User("443797774@qq.com", "diego", "234", "", "default");
  }

  @Test
  public void should_save_and_fetch_user_success() throws Exception{
    System.out.println("---- here 2 ----");

    userRepository.save(user);
    System.out.println("--- here ---");
    Optional<User> userOptional = userRepository.findById(user.getId());
    assertThat(userOptional.get().getEmail(),is(user.getEmail()));
  }
}