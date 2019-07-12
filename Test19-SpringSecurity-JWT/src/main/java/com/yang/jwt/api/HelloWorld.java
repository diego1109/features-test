package com.yang.jwt.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorld {

  @GetMapping
  public String firstPage(){
    return "hello JWT";
  }
}
