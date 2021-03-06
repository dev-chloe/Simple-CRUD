package com.toyproject.simplecrudapp.domains.req;

import com.toyproject.simplecrudapp.domains.User;
import com.toyproject.simplecrudapp.utils.fixed.RegExp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
public class UserReqDto implements IReqDto< User > {

  @Pattern(regexp = RegExp.Email ,message = "'email' is invalid")
  private final String email;

  @Size(min = 8, message = "'password' must be longer than 8 words" )
  @Size(max = 30, message = "'password' must be shorter than 30 words" )
  private final String password;

  @Size(min = 2, message = "'nickname' must be longer than 2 words" )
  @Size(max = 8, message = "'nickname' must be shorter than 8 words" )
  private final String nickname;

  @Override
  public boolean equals( Object o ) {
    if ( Objects.isNull( o )) {
      return false;
    }
    if ( this == o ) {
      return true;
    }
    if ( !(o instanceof UserReqDto) ) {
      return false;
    }
    UserReqDto that = (UserReqDto) o;
    return Objects.equals( email, that.email )
        && Objects.equals( password, that.password )
        && Objects.equals( nickname, that.nickname );
  }

  @Override
  public int hashCode() {
    return Objects.hash( email, password, nickname );
  }

  @Override
  public String toString() {
    return String.format( "UserReqDto > email: '%s', nickname: '%s', password: (hidden)", email, nickname);
  }

  @Override
  public User toEntity() {
    return User.builder()
               .email(email)
               .password(password) // TODO Password Encrypt
               .nickname(nickname)
               .build();
  }

}
