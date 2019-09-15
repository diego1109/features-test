package com.yang.security.api;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import com.yang.security.application.data.UserData;
import com.yang.security.domain.User;
import com.yang.security.infrastructure.mybatis.query.MybatisUserQueryService;
import com.yang.security.infrastructure.mybatis.repository.MybatisUserRepository;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserApi.class)
public class UserApiTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private MybatisUserQueryService mybatisUserQueryService;

  @MockBean
  private MybatisUserRepository userRepository;

  private String defaultAvatar = "https://static.productionready.io/images/smiley-cyrus.jpg";
  private String email = "1027@qq.com";
  private String userName = "diego";
  private String password = "123";
  private User newUser;

  @Before
  public void setUp(){
    RestAssuredMockMvc.mockMvc(mockMvc);
    newUser = new User(email, userName, password, "", defaultAvatar);
  }


  @Test
  public void should_create_user_succeed(){
    UserData userData = new UserData(newUser.getId(), newUser.getEmail(), newUser.getUserName(),
        newUser.getBio(), newUser.getImage());

    Mockito.when(mybatisUserQueryService.findById(any())).thenReturn(
        Optional.of(userData));

    Map<String,Object> user = new HashMap<String, Object>() {{
      put("email", email);
      put("password", password);
      put("username", userName);
    }};

    given()
        .contentType(ContentType.JSON)
        .body(user)
        .when()
        .post("/users")
        .prettyPeek()
        .then()
        .statusCode(201);
  }

  @Test
  public void should_query_user_succeed(){
    UserData userData = new UserData(newUser.getId(), newUser.getEmail(), newUser.getUserName(),
        newUser.getBio(), newUser.getImage());

    Mockito.when(mybatisUserQueryService.findByUsername(eq(newUser.getUserName()))).thenReturn(
        Optional.of(userData));

    given()
        .postProcessors(httpBasic("admin","password"))
        .when()
        .get("/users/{username}", newUser.getUserName())
        .prettyPeek()
        .then()
        .statusCode(200);
  }

  @Test
  public void should_403_if_query_user_with_no_admin(){
    UserData userData = new UserData(newUser.getId(), newUser.getEmail(), newUser.getUserName(),
        newUser.getBio(), newUser.getImage());

    Mockito.when(mybatisUserQueryService.findByUsername(eq(newUser.getUserName()))).thenReturn(
        Optional.of(userData));

    given()
        .postProcessors(httpBasic("user","123"))
        .when()
        .get("/users/{username}", newUser.getUserName())
        .prettyPeek()
        .then()
        .statusCode(403);
  }

  @Test
  public void should_401_if_query_user_with_Unauthorized_user(){
    UserData userData = new UserData(newUser.getId(), newUser.getEmail(), newUser.getUserName(),
        newUser.getBio(), newUser.getImage());

    Mockito.when(mybatisUserQueryService.findByUsername(eq(newUser.getUserName()))).thenReturn(
        Optional.of(userData));

    given()
        .postProcessors(httpBasic("user","12345"))
        .when()
        .get("/users/{username}", newUser.getUserName())
        .prettyPeek()
        .then()
        .statusCode(401);
  }
}