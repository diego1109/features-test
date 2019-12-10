package com.yang.hateoas.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

@ToString
@Getter
public class Customer extends ResourceSupport {

  private String customerName;
  private String customerId;
  private String companyName;

  public Customer(String customerName, String customerId, String companyName) {
    this.customerName = customerName;
    this.customerId = customerId;
    this.companyName = companyName;
  }
}
