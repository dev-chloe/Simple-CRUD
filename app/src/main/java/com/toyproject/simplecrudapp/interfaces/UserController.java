package com.toyproject.simplecrudapp.interfaces;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.UserReqDto;
import com.toyproject.simplecrudapp.domains.UserResDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PostMapping("/users")
  @ResponseStatus( HttpStatus.CREATED )
  public UserResDto signUp(@Validated UserReqDto userReqDto ) {

    User newUser = userReqDto.toEntity();

    return UserResDto.factory(newUser);
  }

}
