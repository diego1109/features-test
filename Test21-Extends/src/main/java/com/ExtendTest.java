package com;

public class ExtendTest {
  public static void main(String[] args){

    Son son = new Son("diego");

    System.out.println(son.getName());

    Father father = son;

    System.out.println(father.getName());
  }
}
