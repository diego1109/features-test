package com.yang.hateoas.api;


import static java.util.Arrays.asList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.yang.hateoas.application.CustomerService;
import com.yang.hateoas.application.OrderService;
import com.yang.hateoas.application.data.CustomerData;
import com.yang.hateoas.domain.Customer;
import com.yang.hateoas.domain.Order;
import java.util.List;
import org.apache.el.parser.AstListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerService customerService;
  private OrderService orderService;

  @Autowired
  public CustomerController(CustomerService customerService,
                            OrderService orderService) {
    this.customerService = customerService;
    this.orderService = orderService;
  }

//  @GetMapping("/{customerId}")
//  public ResponseEntity getCustomerById(@PathVariable String customerId){
//    Customer customer = customerService.getCustomerById(customerId);
//    return ResponseEntity.ok(customer);
//  }



  @GetMapping("/{customerName}")
  public ResponseEntity getCustomerByName(@PathVariable String customerName) {
    Customer customer = customerService.getCustomerByName(customerName);
    Link link = new Link("http://localhost:8080/spring-security-rest/api/customers/10A");
    customer.add(
        linkTo(CustomerController.class).slash(customer.getCustomerName())
            .slash(customer.getCustomerId()).withSelfRel());
    customer.add(link);
    return ResponseEntity.ok(customer);
  }

  @GetMapping("/{customerName}/withCustomLinks")
  public ResponseEntity getCustomerByNameWithCustomLinks(@PathVariable String customerName) {
    Customer customer = customerService.getCustomerByName(customerName);
    CustomerData customerData = new CustomerData(customer);
    Link link = new Link("http://localhost:8080/spring-security-rest/api/customers/10A");
    com.yang.hateoas.api.Link customLink = new com.yang.hateoas.api.Link(link.getRel(),
        link.getHref());
    return ResponseEntity.ok(new CustomerDataResource(customerData, customLink));
  }

  @GetMapping("/{customerName}/withMultipleCustomLinks")
  public ResponseEntity getCustomerByNameWithMultipleCustomLinks(@PathVariable String customerName) {
    Customer customer = customerService.getCustomerByName(customerName);
    CustomerData customerData = new CustomerData(customer);
    Link link = new Link("http://localhost:8080/spring-security-rest/api/customers/10A");
    com.yang.hateoas.api.Link customLink = new com.yang.hateoas.api.Link(link.getRel(),
        link.getHref());
    com.yang.hateoas.api.Link customAnotherLink = new com.yang.hateoas.api.Link("another_self",
        linkTo(CustomerController.class).slash(customer.getCustomerName())
            .slash(customer.getCustomerId()).withSelfRel().getHref());
    return ResponseEntity.ok(new CustomerDataResource(customerData, asList(customLink,customAnotherLink)));
  }

  @GetMapping("/{customerId}/orders/{orderId}")
  public Order getOrderByIdForCustomer(@PathVariable String customerId,
                                       @PathVariable String orderId) {
    return orderService.getOrderByIdForCustomer(customerId, orderId);
  }


  @GetMapping("/{customerId}/orders")
  public ResponseEntity getOrdersForCustomer(@PathVariable String customerId) {
    List<Order> orders = orderService.getAllOrdersForCuntomer(customerId);
    for (Order order : orders) {
      Link selfLink = linkTo(methodOn(CustomerController.class)
          .getOrderByIdForCustomer(customerId, order.getOrderId())).withSelfRel();
      order.add(selfLink);
    }
    Link link = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId))
        .withSelfRel();
    Resources<Order> result = new Resources<>(orders, link);
    System.out.println("result:"+result.toString());
    return ResponseEntity.ok(result);
  }


}

class CustomerDataResource extends Resource<CustomerData> {

  public CustomerDataResource(CustomerData content, com.yang.hateoas.api.Link links) {
    super(content, links);
  }
  public CustomerDataResource(CustomerData content, List<com.yang.hateoas.api.Link> links) {
    super(content, links);
  }
}

































