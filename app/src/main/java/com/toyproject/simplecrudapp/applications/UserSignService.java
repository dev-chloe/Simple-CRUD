package com.toyproject.simplecrudapp.applications;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.domains.UserRepository;
import com.toyproject.simplecrudapp.domains.req.UserReqDto;
import com.toyproject.simplecrudapp.domains.res.UserResDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class UserSignService {

  private final Logger logger = LoggerFactory.getLogger( UserSignService.class );

  @Autowired
  UserRepository userRepository;

  public UserResDto signUp( @Validated UserReqDto userReqDto ) {

    User reqUser = userReqDto.toEntity();
    User newUser = userRepository.save( reqUser );
    return UserResDto.factory( newUser );
  }
}
