package com.toyproject.simplecrudapp.interfaces;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

  @PostMapping("/sign-up")
  public User signUp(@Validated UserDto userDto) {

    return userDto.toEntity();
  }
}
