package com.toyproject.simplecrudapp.interfaces;

import com.toyproject.simplecrudapp.applications.UserSignService;
import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.req.UserReqDto;
import com.toyproject.simplecrudapp.domains.res.UserResDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final Logger logger = LoggerFactory.getLogger( UserController.class );

  private final String _signUp = "sign-up | ";
  private final String _start  = "start : ";
  private final String _finish = "finish: ";

  @Autowired
  UserSignService userSignService;

  @PostMapping("/users")
  @ResponseStatus( HttpStatus.CREATED )
  public UserResDto signUp(@Validated UserReqDto userReqDto ) {

    logger.info( _signUp + _start + userReqDto.toString() );
    UserResDto userResDto = userSignService.signUp( userReqDto );
    logger.info( _signUp + _finish + userResDto.toString() );
    return userResDto;
  }
}
