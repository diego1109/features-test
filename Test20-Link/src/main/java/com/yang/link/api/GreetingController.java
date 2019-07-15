package com.yang.link.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.yang.link.model.Greeting;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String TEMPLATE = "hello,%s!";

  /**
   * 加上link
   * @param name
   * @return
   */

  @RequestMapping("/greeting")
  public HttpEntity<Greeting> greeting(
      @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
    Greeting greeting = new Greeting(String.format(TEMPLATE, name));
    greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
    return new ResponseEntity<>(greeting, HttpStatus.OK);
  }


  /**
   * 未加link
   * @param name
   * @return
   */
  @RequestMapping("/greeting2")
  public HttpEntity<Greeting> greeting2(
      @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
    Greeting greeting = new Greeting(String.format(TEMPLATE, name));
    return new ResponseEntity<>(greeting, HttpStatus.OK);
  }
}
