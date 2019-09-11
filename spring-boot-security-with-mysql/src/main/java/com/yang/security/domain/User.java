package com.yang.security.domain;

import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
  private String id;
  private String email;
  private String userName;
  private String password;
  private String bio;
  private String image;

  public User(String email, String userName, String password, String bio, String image) {
    this.id = UUID.randomUUID().toString();
    this.email = email;
    this.userName = userName;
    this.password = password;
    this.bio = bio;
    this.image = image;
  }

  public void update(String email, String userName, String password, String bio, String image) {
    if (!"".equals(email)) {
      this.email = email;
    }
    if (!"".equals(userName)) {
      this.userName = userName;
    }
    if (!"".equals(password)) {
      this.password = password;
    }
    if (!"".equals(bio)) {
      this.bio = bio;
    }
    if (!"".equals(image)) {
      this.image = image;
    }
  }
}
