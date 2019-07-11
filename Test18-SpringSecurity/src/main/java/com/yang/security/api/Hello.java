package com.yang.security.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hello {

  @GetMapping
  public String home(){
    return "this is home page";
  }

  @GetMapping("hello")
  public String helloSpringSecurity(){
    return "hello Spring Security";
  }

}
