package com.yang.security.api;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.yang.security.application.UserQueryService;
import com.yang.security.application.data.UserData;
import com.yang.security.domain.User;
import com.yang.security.domain.UserRepository;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserApi {

  private UserRepository userRepository;
  private UserQueryService userQueryService;
  private String defaultImage = "test image";

  @PostMapping
  public ResponseEntity createUser(@Valid @RequestBody RegisterParam registerParam, BindingResult bindingResult) {

    User user = new User(
        registerParam.getEmail(),
        registerParam.getUsername(),
        registerParam.getPassword(),
        "",
        defaultImage);

    userRepository.save(user);
    UserData userData = userQueryService.findById(user.getId()).get();
    return ResponseEntity.status(201).body(userData);
  }

}


@Getter
@JsonRootName("user")
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