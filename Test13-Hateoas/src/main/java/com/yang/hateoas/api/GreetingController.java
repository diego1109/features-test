package com.yang.hateoas.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.yang.hateoas.domain.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String TEMPLATE = "Hello, %s!";
  
  @RequestMapping("/greeting")
  public ResponseEntity greeting(
      @RequestParam(value = "name", required = false, defaultValue = "world") String name) {
    Greeting greeting = new Greeting(String.format(TEMPLATE, name));
    greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
    return ResponseEntity.ok(greeting);
  }
}