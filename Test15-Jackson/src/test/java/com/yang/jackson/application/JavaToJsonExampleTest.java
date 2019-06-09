package com.yang.jackson.application;

import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yang.jackson.model.Employee;
import com.yang.jackson.model.Name;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class JavaToJsonExampleTest {
  
  private Employee employee;
  
  @Before
  public void setUp() {
    employee = new Employee(1, "Lokesh", "Gupta");
    System.out.println("employee:" + employee);
    System.out.println("--- setUp ---");
  }
  
  @Test
  public void serialization_object_to_json() {
    String jsonStr = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
      jsonStr = objectMapper.writeValueAsString(employee);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(jsonStr);
  }
  
  @Test
  public void deserialization_json_to_object() {
    String jsonStr = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      jsonStr = objectMapper.writeValueAsString(employee);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Employee retchedEmployee = objectMapper.readValue(jsonStr, Employee.class);
      assertThat(retchedEmployee.getId(), is(employee.getId()));
      System.out.println(retchedEmployee.getId() + "\t" + employee.getId());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void deserialization_json_with_root_to_object() {
    String jsonStr = null;
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    try {
      jsonStr = objectMapper.writeValueAsString(employee);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Employee retchedEmployee = objectMapper.readValue(jsonStr, Employee.class);
      assertThat(retchedEmployee.getId(), is(employee.getId()));
      assertThat(retchedEmployee.getFristName(), is(employee.getFristName()));
      assertThat(retchedEmployee.getLastName(), is(employee.getLastName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void deserialization_json_partial_property_to_object() {
    String jsonStr = null;
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    try {
      jsonStr = objectMapper.writeValueAsString(employee);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Name name = objectMapper.readValue(jsonStr, Name.class);
      assertThat(name.getFristName(), is(employee.getFristName()));
      assertThat(name.getLastName(), is(employee.getLastName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void serialize_list_to_json_array_and_deserialize() {
    String jsonArrayStr = null;
    ObjectMapper objectMapper = new ObjectMapper();
    List<Employee> employees = Arrays.asList(employee,
        new Employee(2, "li", "yy"));
    try {
      jsonArrayStr = objectMapper.writeValueAsString(employees);
      System.out.println(jsonArrayStr);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    try {
      List<Employee> retchedEmployee = objectMapper
          .readValue(jsonArrayStr, new TypeReference<List<Employee>>(){});
      assertThat(retchedEmployee.size(),is(2));
      assertThat(retchedEmployee.get(0).getId(),is(employees.get(0).getId()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void serialize_map_to_and_deserialize() {
    String jsonArrayStr = null;
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String,Object> color = new HashMap<String,Object>(){{
      put("red","12");
      put("black","13");
    }};
    try {
      jsonArrayStr = objectMapper.writeValueAsString(color);
      System.out.println(jsonArrayStr);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    try {
      Map<String,Object> retchedColors = objectMapper
          .readValue(jsonArrayStr, new TypeReference<Map<String,Object>>(){});
      assertThat(retchedColors.size(),is(2));
      assertThat(retchedColors.get("red"),is(color.get("red")));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
  
