package com.yang.jwt.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class JwtRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  private String userName;
  private String password;

  public JwtRequest(String userName, String password) {
    this.setUserName(userName);
    this.setPassword(password);
  }

}
