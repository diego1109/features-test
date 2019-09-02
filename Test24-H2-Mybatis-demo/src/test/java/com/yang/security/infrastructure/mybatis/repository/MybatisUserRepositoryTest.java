package com.yang.security.infrastructure.mybatis.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.yang.security.domain.User;
import com.yang.security.domain.UserRepository;
import java.util.Optional;
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
@Import(MybatisUserRepository.class)
public class MybatisUserRepositoryTest {
  @Autowired
  private UserRepository userRepository;
  private User user;

  @Before
  public void setUp() throws Exception {
    user = new User("aisensiy@163.com", "aisensiy", "123", "", "default");
  }

  @Test
  public void should_save_and_fetch_user_success() throws Exception {
    userRepository.save(user);
    Optional<User> userOptional = userRepository.findByUsername("aisensiy");
    assertThat(userOptional.get(), is(user));
  }
}