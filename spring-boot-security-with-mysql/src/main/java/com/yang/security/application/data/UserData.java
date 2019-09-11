package com.yang.security.application.data;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserData {
  private String id;
  private String email;
  private String username;
  private String bio;
  private String image;


  public UserData(String id, String email, String username, String bio, String image) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.bio = bio;
    this.image = image;
  }
}
