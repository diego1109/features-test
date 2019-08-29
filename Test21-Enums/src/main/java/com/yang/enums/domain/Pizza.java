package com.yang.enums.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pizza {

  private PizzaStatus status;

  public Pizza(PizzaStatus status) {
    this.status = status;
  }

  public enum PizzaStatus {
    ORDERED, READY, DELIVERED;
  }

  public int getDeliveryTimeInDays() {
    switch (status) {
      case READY:
        return 2;
      case ORDERED:
        return 5;
      case DELIVERED:
        return 0;
    }
    return 0;
  }

  public Boolean isDeliverable() {
    if (getStatus() == PizzaStatus.READY) {
      return true;
    }
    return false;
  }

  private PizzaStatus getStatus() {
    return status;
  }
}
