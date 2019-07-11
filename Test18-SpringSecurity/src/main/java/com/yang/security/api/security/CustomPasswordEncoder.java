package com.yang.security.api.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

  @Override
  public boolean upgradeEncoding(String encodedPassword) {
    return false;
  }

  @Override
  public String encode(CharSequence rawPassword) {
    return rawPassword.toString();
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return encodedPassword.equals(rawPassword.toString());
  }
}
