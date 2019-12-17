package com.yang.serialization.api;

import com.yang.serialization.domain.Customer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerializeApi {

  private Customer customer;
  private String fileName = "yourfile.txt";

  public SerializeApi() {
    this.customer = new Customer("12345", "diego", "openbayes");
  }

  @GetMapping("/serialize")
  public ResponseEntity serializeDemo() {
    Customer fetch = null;
    try {
      FileOutputStream fileOutputStream
          = new FileOutputStream(fileName);
      ObjectOutputStream objectOutputStream
          = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(customer);
      objectOutputStream.flush();
      objectOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      FileInputStream fileInputStream
          = new FileInputStream(fileName);
      ObjectInputStream objectInputStream
          = new ObjectInputStream(fileInputStream);
      fetch = (Customer) objectInputStream.readObject();
      objectInputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return ResponseEntity.ok(fetch);
  }

  @GetMapping("/deserialize-broken-file")
  public ResponseEntity deserializeBrokenFile() {
    Customer fetch = null;
    try {
      FileInputStream fileInputStream
          = new FileInputStream(fileName);
      ObjectInputStream objectInputStream
          = new ObjectInputStream(fileInputStream);
      fetch = (Customer) objectInputStream.readObject();
      objectInputStream.close();
    } catch (IOException e) {
      System.out.println("IOException: file not found");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("ClassNotFoundException: file maybe broken");
      e.printStackTrace();
    }
    return ResponseEntity.ok(fetch);
  }
}
