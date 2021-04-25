package com.toyproject.simplecrudapp.interfaces;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

  @PostMapping("/sign-up")
  public User signUp(
    @RequestParam(name="email") String email,
    @RequestParam(name="password") String password,
    @RequestParam(name="nickname") String nickname
  ) {

    UserDto newUserDto = UserDto.builder()
                                .email( email )
                                .password( password )
                                .nickname( nickname )
                                .build();

    return newUserDto.toEntity();
  }
}
