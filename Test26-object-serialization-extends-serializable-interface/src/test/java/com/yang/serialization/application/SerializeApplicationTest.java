package com.yang.serialization.application;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.yang.serialization.domain.Customer;
import com.yang.serialization.domain.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Before;
import org.junit.Test;


public class SerializeApplicationTest {

  private Customer customer;
  private Customer existCustomer;
  private String fileName;
  private String existfileName = "file.txt";

  @Before
  public void setUp() throws IOException {
    customer = new Customer("12345", "diego", "openbayes");
    fileName = "file.txt";
    existCustomer = new Customer("98765", "mason", "company1");
    FileOutputStream fileOutputStream
        = new FileOutputStream(existfileName);
    ObjectOutputStream objectOutputStream
        = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(existCustomer);
    objectOutputStream.flush();
    objectOutputStream.close();
  }


  @Test
  public void serialize_and_deserialize_succeed()
      throws IOException, ClassNotFoundException {

    FileOutputStream fileOutputStream
        = new FileOutputStream("yourfile.txt");
    ObjectOutputStream objectOutputStream
        = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(customer);
    objectOutputStream.flush();
    objectOutputStream.close();

    FileInputStream fileInputStream
        = new FileInputStream("yourfile.txt");
    ObjectInputStream objectInputStream
        = new ObjectInputStream(fileInputStream);
    Customer p2 = (Customer) objectInputStream.readObject();
    objectInputStream.close();

    System.out.println("p2:" + p2);
    assertThat(customer, is(p2));
  }

  @Test
  public void only_deserialize_succeed()
      throws IOException, ClassNotFoundException {

    FileInputStream fileInputStream
        = new FileInputStream(existfileName);
    ObjectInputStream objectInputStream
        = new ObjectInputStream(fileInputStream);
    Customer p2 = (Customer) objectInputStream.readObject();
    objectInputStream.close();

    System.out.println("p2:" + p2);

  }

  @Test
  public void deserialize_customer_to_student() {
    try {
      FileInputStream fileInputStream
          = new FileInputStream(existfileName);
      ObjectInputStream objectInputStream
          = new ObjectInputStream(fileInputStream);
      Student p2 = (Student) objectInputStream.readObject();
      objectInputStream.close();
      System.out.println("p2:" + p2);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }


}