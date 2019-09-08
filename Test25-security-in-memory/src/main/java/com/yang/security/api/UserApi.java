package com.yang.security.api;

import com.yang.security.api.exception.InvalidRequestException;
import com.yang.security.api.exception.ResourceNotFoundException;
import com.yang.security.application.data.UserData;
import com.yang.security.domain.User;
import com.yang.security.domain.UserRepository;
import com.yang.security.infrastructure.mybatis.query.MybatisUserQueryService;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserApi {

  private UserRepository userRepository;
  private MybatisUserQueryService mybatisUserQueryService;
  private String defaultImage = "test image";

  @Autowired
  public UserApi(UserRepository userRepository, MybatisUserQueryService mybatisUserQueryService) {
    this.userRepository = userRepository;
    this.mybatisUserQueryService = mybatisUserQueryService;
  }

  @PostMapping
  public ResponseEntity createUser(
      @Valid @RequestBody RegisterParam registerParam,
      BindingResult bindingResult,
      @AuthenticationPrincipal User current) {

    if (bindingResult.hasErrors()) {
      throw new InvalidRequestException();
    }

    User user =
        new User(
            registerParam.getEmail(),
            registerParam.getUsername(),
            registerParam.getPassword(),
            "",
            defaultImage);

    userRepository.save(user);
    UserData userData = mybatisUserQueryService.findById(user.getId()).get();
    return ResponseEntity.status(201).body(userData);
  }

  @GetMapping("/{username}")
  public ResponseEntity getUser(
      @PathVariable("username") String userName, @AuthenticationPrincipal User current) {
    UserData userData =
        mybatisUserQueryService
            .findByUsername(userName)
            .orElseThrow(ResourceNotFoundException::new);
    return ResponseEntity.ok(userData);
  }
}

@Getter
@NoArgsConstructor
class RegisterParam {
  @NotBlank(message = "can't be empty")
  @Email(message = "should be an email")
  private String email;

  @NotBlank(message = "can't be empty")
  private String username;

  @NotBlank(message = "can't be empty")
  private String password;
}
