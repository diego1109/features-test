package com.johnny.chapter2.po;

import java.util.List;
import lombok.Data;

@Data
public class Person {
  private Long id;
  private List<String> interest;

}
