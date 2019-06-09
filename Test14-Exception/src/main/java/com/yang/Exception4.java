package com.yang;

public class Exception4 extends Exception {
  private String msg;
  
  public Exception4(String msg) {
    this.msg = msg;
    System.out.println("Exception4()");
  }
  protected void showS(){
    System.out.println("Message from Exception4:"+msg);
  }
  
}

class Test8{
  public static void f() throws Exception4{
    System.out.println("f()");
    throw new Exception4("Ouch from f()");
  }
}