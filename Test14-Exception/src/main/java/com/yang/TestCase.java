package com.yang;

import java.io.IOError;
import java.io.IOException;

public class TestCase {

  /**
   * 测试多个异常捕获
   */

  public static void ex10(String flag) throws Exception{
    if (flag == "runtime") {
      throw new SearchSpaceExhaustedException();
      }
    if (flag == "ioe"){
      throw new IOException();
    }
  }


  public static class SearchSpaceExhaustedException extends RuntimeException {

  }

}

