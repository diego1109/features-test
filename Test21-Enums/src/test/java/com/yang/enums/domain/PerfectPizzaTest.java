package com.yang.enums.domain;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.yang.enums.domain.PerfectPizza.PizzaStatus;
import org.junit.Test;

public class PerfectPizzaTest {


  @Test
  public void enums_constructor_test(){
    PerfectPizza perfectPizza = new PerfectPizza(PizzaStatus.ORDERED);
    assertThat(perfectPizza.getDeliveryTimeInDays(),is(5));
    assertThat(perfectPizza.getStatus().isOrdered(),is(true));
  }
}