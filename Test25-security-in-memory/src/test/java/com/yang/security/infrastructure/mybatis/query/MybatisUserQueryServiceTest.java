package com.yang.security.infrastructure.mybatis.query;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.yang.security.application.UserQueryService;
import com.yang.security.application.data.UserData;
import com.yang.security.domain.User;
import com.yang.security.domain.UserRepository;
import com.yang.security.infrastructure.mybatis.repository.MybatisUserRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MybatisTest
@Import({MybatisUserRepository.class,MybatisUserQueryService.class})
public class MybatisUserQueryServiceTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserQueryService userQueryService;

  private User user;

  @Before
  public void setUp() throws Exception {
    user = new User("diego@163.com", "diego", "123", "", "default");
  }

  @Test
  public void should_query_user_succeed(){
    userRepository.save(user);
    Optional<UserData> optional = userQueryService.findByUsername(user.getUserName());
    assertThat(optional.isPresent(),is(true));
    UserData fetched = optional.get();
    assertThat(fetched.getId(),is(user.getId()));
    assertThat(fetched.getUsername(),is(user.getUserName()));
    assertThat(fetched.getBio(),is(user.getBio()));
    assertThat(fetched.getEmail(),is(user.getEmail()));
    assertThat(fetched.getImage(),is(user.getImage()));
  }

}