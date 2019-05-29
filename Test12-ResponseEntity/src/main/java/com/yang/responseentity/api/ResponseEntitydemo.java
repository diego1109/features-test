package com.yang.responseentity.api;

import java.util.Collection;
import javax.jws.soap.SOAPBinding.Use;
import jdk.net.SocketFlow.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseEntitydemo {
  
  /**
   * ResponseEntity构建response有两种方式
   * 1.new ResponseEntity()  new一个新的ResponseEntity。
   * 2.调用ResponseEntity的静态方法。
   *
   */
  
  @GetMapping("/hello")
  public ResponseEntity hello(){
    return new ResponseEntity("hello world!", HttpStatus.OK);
  }
  
  @GetMapping("/get_user")
  public ResponseEntity getUser(){
    return ResponseEntity.ok(new User("lyy","23"));
  }
  
}

@Getter
@AllArgsConstructor
class User{
 private String name;
 private String age;
 
}
