package com.yang.enums.domain;

import com.yang.enums.domain.Pizza.PizzaStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class PerfectPizza {

  private PizzaStatus status;

  public PerfectPizza(PizzaStatus status) {
    this.status = status;
  }


  public int getDeliveryTimeInDays() {
    return status.getTimeToDelivery();
  }

  public Boolean isDeliverable() {
    if (getStatus() == PizzaStatus.READY) {
      return true;
    }
    return false;
  }

  public PizzaStatus getStatus() {
    return status;
  }

  public enum PizzaStatus {
    ORDERED(5) {
      @Override
      public boolean isOrdered() {
        return true;
      }

      @Override
      public int getTimeToDelivery() {
        return 5;
      }
    }, READY(2) {
      @Override
      public int getTimeToDelivery() {
        return 2;
      }
    }, DELIVERED(0) {
      @Override
      public int getTimeToDelivery() {
        return 0;
      }
    };


    private int timeToDelivery;

    PizzaStatus(int timeToDelivery) {
      this.timeToDelivery = timeToDelivery;
    }

    public boolean isOrdered() {
      return false;
    }

    public abstract int getTimeToDelivery();
  }

}

