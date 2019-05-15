package com.johnny.chapter2.mapper;

import com.johnny.chapter2.po.Person;
import com.johnny.chapter2.po.User;
import java.util.List;


public interface UserMapper {
  public List<User> getUser();
  public List<User> getUser2();
  public List<Person> getPerson();

  public int insertUser(User user);
  public int insertUser2(User user);
  public int insertUser3(User user);
//  public int insertUser4(User user);
  public int insertPersion(Person person);

}



