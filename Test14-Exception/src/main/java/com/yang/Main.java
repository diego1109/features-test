package com.yang;

public class Main {
  
  
  public static void ex8(){
    try{
      Test8 test8 = new Test8();
      Test8.f();
    }catch (Exception4 e){
      System.err.println("Caught Exception4");
      e.printStackTrace();
      e.showS();
    }
  }
  
  
  public static void main(String[] args){
    
    ex8();
    
    System.out.println("--- finish all ---");
  }
}
