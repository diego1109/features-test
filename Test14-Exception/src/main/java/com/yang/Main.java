package com.yang;

import com.yang.TestCase.SearchSpaceExhaustedException;
import java.io.IOException;
import java.rmi.server.ExportException;

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

  /**
   * 测试使用e.printStackTrace()后面的程序是否会执行
   */
  public static void ex9() {
    try {
      throw new Exception();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("--- execute here ---");
  }

  /**
   * 测试多个异常捕获
   */

  public static void ex10() {
    String flag = "runtime";
//    String flag = "ioe";
    try {
      TestCase.ex10(flag);
    } catch (RuntimeException e) {
      System.out.println("--- runtime exception ---");
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("--- IOE exception ---");
      e.printStackTrace();
    }
  }

  public static void main(String[] args){

//    ex8();
//    ex9();
    ex10();
    System.out.println("--- finish all ---");
  }
}
