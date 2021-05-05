package com.toyproject.simplecrudapp.domains.res;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.interfaces.exceptions.UserInternalException;
import com.toyproject.simplecrudapp.utils.fixed.RegExp;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
public class UserResDto {

  @Positive(message = "'id' must be positive number(long)")
  private Long id;

  @Pattern(regexp = RegExp.Email ,message = "'email' is invalid")
  private final String email;

  @Size(min = 2, message = "'nickname' must be longer than 2 words" )
  @Size(min = 8, message = "'nickname' must be shorter than 2 words" )
  private final String nickname;

  public static UserResDto factory( @Valid User userEntity ) {
    if ( Objects.isNull( userEntity.getId() )) {
      throw UserInternalException.ENTITY_ID_NULL;
    }
    return new UserResDto(userEntity);
  }

  private UserResDto( User userEntity ) {
    this.id = userEntity.getId();
    this.email = userEntity.getEmail();
    this.nickname = userEntity.getNickname();
  }

  @Override
  public String toString() {
    return String.format( "UserResDto > id: '%d', email: '%s', nickname: '%s'", id, email, nickname);
  }
}
