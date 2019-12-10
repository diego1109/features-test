package com.yang.hateoas.application;

import com.yang.hateoas.domain.Order;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 这些方法在单元测试中都会被mock
 */

@Service
public class OrderService {

  public List<Order> getAllOrdersForCuntomer(String customerId) {
    return Collections.emptyList();
  }

  public Order getOrderByIdForCustomer(String customerId, String orderId) {
    return null;
  }
}
