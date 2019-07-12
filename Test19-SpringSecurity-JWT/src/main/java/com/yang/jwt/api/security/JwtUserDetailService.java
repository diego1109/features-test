package com.yang.jwt.api.security;

import java.util.ArrayList;
import java.util.Collections;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {

  private final String userNameHardCode = "diego";

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (userNameHardCode.equals(username)) {
      return new User(userNameHardCode,
                      "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                      new ArrayList<>());
    }else {
      throw new UsernameNotFoundException("User not found");
    }
  }
}
