package com.yang.hateoas.domain;


import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

@Getter
@ToString
public class Order extends ResourceSupport {

  private String orderId;
  private double price;
  private int quantity;

  public Order(String orderId, double price, int quantity) {
    this.orderId = orderId;
    this.price = price;
    this.quantity = quantity;
  }
}
