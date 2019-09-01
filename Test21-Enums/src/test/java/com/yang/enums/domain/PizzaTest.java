package com.yang.enums.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.yang.enums.domain.Pizza.PizzaStatus;
import org.junit.Test;


public class PizzaTest {

  @Test
  public void compare_enum_test(){
    Pizza testPz = new Pizza(PizzaStatus.READY);
    assertThat(testPz.isDeliverable(),is(true));
    assertThat(testPz.getDeliveryTimeInDays(),is(2));
  }

  @Test
  public void print_enums_ordinal() {
    for (PizzaStatus status : PizzaStatus.values()) {
      System.out.println(status.ordinal() + 1);
    }
  }

}