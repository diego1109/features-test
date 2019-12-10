package com.yang.hateoas.application.data;

import com.sun.tools.internal.ws.wsdl.document.jaxws.CustomName;
import com.yang.hateoas.domain.Customer;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

@ToString
@Getter
public class CustomerData extends ResourceSupport {
  private String customerName;
  private String customerId;
  private String companyName;

  public CustomerData(String customerName, String customerId, String companyName) {
    this.customerName = customerName;
    this.customerId = customerId;
    this.companyName = companyName;
  }

  public CustomerData(Customer customer){
    this.customerId = customer.getCustomerId();
    this.companyName = customer.getCompanyName();
    this.customerName = customer.getCustomerName();
  }
}
