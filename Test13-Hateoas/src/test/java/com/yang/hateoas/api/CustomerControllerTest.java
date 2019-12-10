package com.yang.hateoas.api;


import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.yang.hateoas.application.CustomerService;
import com.yang.hateoas.application.OrderService;
import com.yang.hateoas.domain.Order;
import com.yang.hateoas.util.FixtureDomain;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  CustomerService customerService;

  @MockBean
  OrderService orderService;

  @Before
  public void setUp() {
    RestAssuredMockMvc.mockMvc(mvc);
  }


  /**
   * 这个测试值返回resource本身，没有links。
   */

  @Test
  public void should_get_customer_by_id_succeed() {

    String customerId = "diego";

    when(customerService.getCustomerById(eq(customerId)))
        .thenReturn(FixtureDomain.getCustomerById(customerId));

    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/customers/{customerID}", customerId)
        .prettyPeek()
        .then()
        .statusCode(200);
  }

  /**
   * 这个测试值返回resource和links。
   *
   * 测试：CustomerController.getCustomerByName()方法。
   */

  @Test
  public void should_get_customer_by_name_succeed() {

    String customerName = "diego";

    when(customerService.getCustomerByName(eq(customerName)))
        .thenReturn(FixtureDomain.getCustomerById(customerName));

    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/customers/{customerName}", customerName)
        .prettyPeek()
        .then()
        .statusCode(200);
  }

  /**
   * 测试：CustomerController.getOrdersForCustomer()方法。
   */
  @Test
  public void should_get_all_orders_for_customer_succeed() {
    String customerId = "10A";
    List<Order> orders = asList(new Order("001A", 250, 25),
        new Order("002A", 250, 12));

    when(orderService.getAllOrdersForCuntomer(any())).thenReturn(orders);

    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/customers/{customerId}/orders",customerId)
        .prettyPeek()
        .then()
        .statusCode(200);
  }
}