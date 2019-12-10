package com.yang.hateoas.application;

import com.yang.hateoas.domain.Customer;
import com.yang.hateoas.util.FixtureDomain;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  public Customer getCustomerById(String customerId) {
      return FixtureDomain.getCustomerById(customerId);
  }

  public Customer getCustomerByName(String customerName) {
    return FixtureDomain.getCustomerByName(customerName);
  }
}
