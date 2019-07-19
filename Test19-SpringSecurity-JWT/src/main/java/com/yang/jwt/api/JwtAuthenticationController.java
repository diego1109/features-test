package com.yang.jwt.api;

import com.yang.jwt.api.security.JwtTokenUtil;
import com.yang.jwt.api.security.JwtUserDetailService;
import com.yang.jwt.model.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailService jwtUserDetailService;

  public ResponseEntity<?> CreateAuthenticationToken(
      @RequestBody JwtRequest authenticationRequest) throws Exception {
    authenticationManager
        .authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
  }


}
