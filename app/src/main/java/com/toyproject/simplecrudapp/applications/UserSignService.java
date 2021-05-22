package com.toyproject.simplecrudapp.applications;

import com.toyproject.simplecrudapp.domains.entity.User;
import com.toyproject.simplecrudapp.domains.UserRepository;
import com.toyproject.simplecrudapp.domains.req.UserReqDto;
import com.toyproject.simplecrudapp.domains.res.UserResDto;
import com.toyproject.simplecrudapp.interfaces.exceptions.UserRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSignService {

  private final Logger logger = LoggerFactory.getLogger( UserSignService.class );

  @Autowired
  UserRepository userRepository;

  public UserSignService( UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserResDto signUp( UserReqDto userReqDto ) {
    // Check
    User reqUser = userReqDto.toEntity();
    if ( hasAlreadyDuplicatedEmail( reqUser ) ) {
      throw UserRequestException.DUPLICATED_EMAIL;
    }
    logger.info(String.format( "PASS > The email(%s) is unique.", reqUser.getEmail() ));

    // Insert
    User newUser = userRepository.save( reqUser );
    logger.info(String.format("PASS > The UserEntity has been inserted. - id: '%d'", newUser.getId()));
    return UserResDto.factory( newUser );
  }

  public boolean hasAlreadyDuplicatedEmail(User targetUser) {
    final String email = targetUser.getEmail();
    return userRepository.findByEmail( email ).isPresent();
  }
}
