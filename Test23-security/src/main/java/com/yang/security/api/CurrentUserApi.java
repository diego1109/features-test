package com.yang.security.api;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.yang.security.application.UserQueryService;
import com.yang.security.application.data.UserData;
import com.yang.security.domain.User;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class CurrentUserApi {
  private UserQueryService userQueryService;

  @Autowired
  public CurrentUserApi(UserQueryService userQueryService) {
    this.userQueryService = userQueryService;
  }


}
