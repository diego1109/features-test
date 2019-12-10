package com.yang.hateoas.util;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.yang.hateoas.domain.Customer;
import com.yang.hateoas.domain.Order;

public class FixtureDomain {

  public static Customer getCustomer() {
    return new Customer("10A", "JanE", "ABC company");
  }

  public static Customer getCustomerById(String customerId) {
    return new Customer(customerId, "JanE", "ABC company");
  }

  public static Customer getCustomerByName(String customerName) {
    return new Customer("10A", customerName, "ABC company");
  }

  public static Order getCustomOrder(String id, double price, int quantity){
    return new Order(id,price,quantity);
  }
}
