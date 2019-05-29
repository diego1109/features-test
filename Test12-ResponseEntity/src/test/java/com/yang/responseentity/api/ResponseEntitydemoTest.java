package com.yang.responseentity.api;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.core.IsNull.notNullValue;

@WebMvcTest(ResponseEntitydemo.class)
public class ResponseEntitydemoTest {

  @Before
  public void setUp(){
    //通过注入Controller instances 构建一个MockMvc
    RestAssuredMockMvc.standaloneSetup(new ResponseEntitydemo());
  
  }
  
  @Test
  public void hello() {
  given()
      .when()
      .get("/hello")
      .prettyPeek()
      .then()
      .statusCode(200);
  }

  @Test
  public void getUser() {
    given()
        .when()
        .get("/get_user")
        .prettyPeek()
        .then()
        .statusCode(200);
  
  }
}